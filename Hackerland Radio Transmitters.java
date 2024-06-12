import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        Arrays.sort(x);
        int total = 0;
        boolean over = false;
        for(int j = 0; j < x.length; j++) {
            System.err.print(x[j] + " ");
        }
        for(int i = 0; i < x.length; i++) {
            int current = x[i];
            for(int j = i+1; j <  x.length && x[j] <= current+k; j++){
                i++;
            }
            current = x[i];
            total++;
            for(int j = i+1; j < x.length && x[j] <= current+k; j++){
                i++;
            }
            
        }
        System.out.println(total);
       
    }
}
