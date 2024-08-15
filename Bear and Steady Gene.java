import java.io.*;
import java.util.*;

public class B {

	BufferedReader br;
	PrintWriter out;
	StringTokenizer st;
	boolean eof;
	
	static final String GENES = "ACGT";

	void solve() throws IOException {
		int n = nextInt();
		String s = nextToken();
		int[] a = new int[n];
		
		int need = n / 4;
		
		int[] cnt = new int[4];
		for (int i = 0; i < n; i++) {
			a[i] = GENES.indexOf(s.charAt(i));
			cnt[a[i]]++;
		}
		
		if (cnt[0] == need && cnt[1] == need && cnt[2] == need && cnt[3] == need) {
			out.println(0);
			return;
		}
		
		int low = 0;
		int high = n;
		
		outer: while (high - low > 1) {
			int mid = (low + high) >> 1;
			
			int[] tmp = cnt.clone();
			for (int i = 0; i < mid; i++) {
				tmp[a[i]]--;
			}
			
			if (tmp[0] <= need && tmp[1] <= need && tmp[2] <= need && tmp[3] <= need) {
				high = mid;
				continue outer;
			}
			
			for (int i = mid; i < n; i++) {
				tmp[a[i - mid]]++;
				tmp[a[i]]--;
				
				if (tmp[0] <= need && tmp[1] <= need && tmp[2] <= need && tmp[3] <= need) {
					high = mid;
					continue outer;
				}
			}
			
			low = mid;
		}
		
		out.println(high);
		
	}

	B() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}

	public static void main(String[] args) throws IOException {
		new B();
	}

	String nextToken() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception e) {
				eof = true;
				return null;
			}
		}
		return st.nextToken();
	}

	String nextString() {
		try {
			return br.readLine();
		} catch (IOException e) {
			eof = true;
			return null;
		}
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
}
