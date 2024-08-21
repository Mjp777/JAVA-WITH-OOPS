import java.util.*;

public class Solution {

    static int[] imp;
    static int luckBalance(int n, int k, int[][] contests) {
        int total=0,j=0;
        for(int i=0;i<n;i++)
        {  
                if(contests[i][1]==0)
                   total+=contests[i][0];
                else
                {
                    imp[j++]=contests[i][0];
                }
        }
        Arrays.sort(imp);
        j=n-1;
        while(j>=0)
        {
        	if(imp[j]!=-1 && k>0)
        		total+=imp[j];
        	else if(imp[j]!=-1 && k<=0)
        		total-=imp[j];
        	k--;j--;
        	if(j==-1 || imp[j]==-1)
        		break;
        }
        return total;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] contests = new int[n][2];
        imp=new int[n];
        for(int contests_i = 0; contests_i < n; contests_i++){
            imp[contests_i]=-1;
            for(int contests_j = 0; contests_j < 2; contests_j++){
                contests[contests_i][contests_j] = in.nextInt();
            }
        }
        int result = luckBalance(n, k, contests);
        System.out.println(result);
        in.close();
    }
}
