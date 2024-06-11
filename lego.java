// Solution for HackerRank Problem "LEGO BLOCKS"
import java.util.Scanner;


public class legoBlocks {
	private int M=0,N=0;
	long[] table= new long[1];
	long[] table2 = new long[1];
	public legoBlocks(int m, int n) {
		M=m;N=n;
		table = new long[N+1];
		table2 = new long[N+1];
		for (int i=0;i<=N;i++) table2[i]=-1;
		filltable2(N);
		for (int i=0;i<=N;i++) 
		{
			long res=1;
			for (int j=0;j<M;j++)
			{
				res=(res*table2[i])%1000000007;
			}
			table2[i]=res;
		}
		for (int i=0;i<=N;i++) 
		{
			table[i]=-1;
		}
	}
	private long filltable2(int n) {
		if(n<0)
		{
			return 0;
		}
		if(table2[n]==-1)
		{
			if (n==0)
			{
				table2[n]=1;
			}
			else 
			{
				table2[n]= (filltable2(n-1)+filltable2(n-2)+filltable2(n-3)+filltable2(n-4))%1000000007;
			}
		}
		return table2[n];
	}
	public static void main(String[] args) {
		Scanner inp=new Scanner(System.in);
		int testcases=inp.nextInt();
		for(int i=0;i<testcases;i++)
		{
			int m = inp.nextInt();
			int n = inp.nextInt();
			legoBlocks T = new legoBlocks(m,n);
			System.out.println (T.evaluate());
		}
		inp.close();

	}
	private long evaluate() {
		long result = helper(N);
		//for (int i=0;i<=N;i++) System.out.print(table[i]+"\t");
		//System.out.print("\n");
		//for (int i=0;i<=N;i++) System.out.print(table2[i]+"\t");
		//System.out.print("\n");
		return result;
		}
	private long helper(int n) {
		if(table[n]==-1)
		{
			if(n==1)
			{
				table[n]=1;
			}
			else
			{
				table[n]=table2[n];
				for(int i=1;i<n;i++)
				{
					table[n]=(table[n]-helper(n-i)*table2[i])%1000000007;
				}
				if(table[n]<0)
				{
					table[n]+=1000000007;
				}
			}
		}
		return table[n];
	}
}
