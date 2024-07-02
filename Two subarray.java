import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class F {

    BufferedReader in;
    StringTokenizer t = new StringTokenizer("");

    public static void main(String[] args) throws IOException {
        try {
            new F().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int nextInt() throws IOException {
        while (!t.hasMoreTokens())
            t = new StringTokenizer(in.readLine());
        return Integer.parseInt(t.nextToken());
    }

    void update(int i, int j, int val, int a[][]) {
        while (i < a.length) {
            if (val > a[i][j])
                a[i][j] = val;
            i++;
        }
    }

    void run() throws IOException {
//        in = new BufferedReader(new FileReader("F.in"));
        in = new BufferedReader(new InputStreamReader(System.in));
        int n = nextInt();
//        int n = 200000;
        int a[] = new int[n];
        int p2[] = new int[n + 2];
        for (int i = 0; i < n; i++) {
//            a[i] = i % 40 + 1;
            a[i] = nextInt();
            p2[i + 2] = p2[(i + 2) / 2] + 1;
        }
        int table[][] = new int[1 + p2[n]][n + 1], s = 0;
        int posit[][] = new int[1 + p2[n]][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            s += a[i];
            table[0][i] = s;
            posit[0][i] = i;
        }
        for (int i = 1; i <= p2[n]; i++) {
            for (int j = 0; j < n; ++j) {
                int nx = j + (1 << (i - 1));
                if (!(nx + (1 << (i - 1)) <= n && table[i - 1][nx] >= table[i - 1][j])) {
                    nx = j;
                }
                table[i][j] = table[i - 1][nx];
                posit[i][j] = posit[i - 1][nx];
            }
        }

        int g = 0, m = 1, kol = n;
        int r[][] = new int[41][40 * 40];
        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < r[i].length; j++) {
                r[i][j] = -1;
            }
        }
        int added[] = new int[n];
        int MX = 40 * 41 / 2;
        for (int i = 0; i < n; i++) {
            if (a[i] > 0) {
                update(a[i], a[i], i, r);
                int mx = a[i] * (a[i] + 1) / 2;
                for (int j = a[i]; j <= mx; j++) {
                    if (r[a[i] - 1][j - a[i]] >= 0)
                        update(a[i], j, r[a[i] - 1][j - a[i]], r);
                }
                ArrayList<Pair<Integer, Integer>> pr = new ArrayList<>();
                pr.add(new Pair<>(-1, -1));
                for (int j = MX; j >= 1; j--) {
                    if (r[40][j] != -1 && added[r[40][j]] != i) {
                        pr.add(new Pair<>(r[40][j], j));
                        added[r[40][j]] = i;
                    }
                }
                Collections.sort(pr, (x, y) -> (x.getKey() - y.getKey()));
                int d = 0;
                for (int j = pr.size() - 1; j > 0; j--) {
                    d = Math.max(d, pr.get(j).getValue());
                    int ll = pr.get(j - 1).getKey() + 1;
                    int pp2 = p2[i - ll + 1];
                    if (table[pp2][i - ((1 << pp2) - 1)] >= table[pp2][ll])
                        ll = i - ((1 << pp2) - 1);
                    int mx1 = table[pp2][ll] - table[0][i + 1] - d;
                    int mxi = i - posit[pp2][ll];
                    if (mx1 > g || (mx1 == g && mxi < m)) {
                        g = mx1;
                        m = mxi;
                        kol = 1;
                    } else if (mx1 == g && mxi == m) {
                        kol++;
                    }
                }
            }
        }
        if (g == 0)
            System.out.println("0 " + n);
        else
            System.out.println(g + " " + kol);
    }
}
