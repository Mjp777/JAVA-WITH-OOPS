//problem description::https://www.hackerrank.com/challenges/missing-numbers/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the missingNumbers function below.
   static void missingNumbers(int[] arr, int[] brr,int m2) {
        int ar[] = new int[100];

        for(int i=0; i<brr.length ;i++){
            int t= brr[i]-m2;
            ar[t]++;
        } 

            for(int i=0; i<arr.length;i++){
            int t= arr[i]-m2;
            ar[t]--;
        }

        for(int i=0; i<100 ;i++){
            if(ar[i]!=0){
                System.out.print((i+m2)+" "); 
            }
        } 
    }


    public static void main(String[] args) throws IOException {
         Scanner scanner = new Scanner(System.in);
         int t = scanner.nextInt();   
   
         int ar[] = new int[t];
        for(int i=0; i<t ; i++){
            ar[i] = scanner.nextInt();
           
            }

         int tt = scanner.nextInt();
         int arr[] = new int[tt];
         int min2=Integer.MAX_VALUE;
         for(int i=0; i<tt ; i++){
            arr[i] = scanner.nextInt();
            if(arr[i]<min2){
                min2=arr[i];
            }
        }
        
          missingNumbers(ar,arr,min2);
        
    }
}
