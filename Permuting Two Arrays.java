import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }
            Arrays.sort(a);
            Arrays.sort(b);
            solve(a, b, k);
        }
    }

    private static void solve(int[] a, int[] b, int k) {
        for(int i=0, j=a.length-1; i<a.length; i++, j--){
            if(a[i]+b[j] < k) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
