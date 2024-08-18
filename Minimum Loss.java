import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long[] prices = new long[n];
        HashMap<Long,Integer> indices = new HashMap<>();

        //Populate prices array with the input
        for(int i = 0; i < n; i++){
            prices[i] = input.nextLong();
            indices.put(prices[i],i);
        }

        Arrays.sort(prices);//Performs a double pivot quicksort and sorts ascending

        Long minimumLoss = Long.MAX_VALUE;

        //Iterate from end to start
        for(int i = n-1; i >0; i--){
            //Make sure it is a smaller loss
            if(prices[i]-prices[i-1] < minimumLoss){
                //Verify if the pair is a valid transaction
                if(indices.get(prices[i]) < indices.get(prices[i-1]))
                    minimumLoss = prices[i]-prices[i-1];
            }
        }

        System.out.println(minimumLoss);

    }
}
