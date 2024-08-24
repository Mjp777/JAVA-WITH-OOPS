import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int Q = input.nextInt();
        //Store answer to each query
        StringBuilder output = new StringBuilder("");

        queries:
        for(int q = 0; q < Q; q++)
        {
            int n = input.nextInt();
            int k = input.nextInt();
            
            //Initialize Input
            int[] A = new int[n];
            int[] B= new int[n];
            for(int i = 0; i < n; i++)
                A[i] = input.nextInt();
            for(int i = 0; i < n; i++)
                B[i] = input.nextInt();
            
            Arrays.sort(A);//Sort ascending
            Arrays.sort(B);//Sort acending      
          
            for(int i = 0; i < n; i++)
            {
                //Traverse A ascending and B descending
                if(A[i]+B[B.length-1-i] < k) //Failed check
                {
                    output.append("NO\n");
                    continue queries;
                }
            }
            
            //Permutation exist
            output.append("YES\n");
            
        }
        //Print the answers to all queries
        System.out.println(output);
    }
}
