import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gridChallenge function below.
    static void gridChallenge(String[] grid,int n) {
        char ll[] = new char[n];
        char b[] = new char[n];
        boolean xx=true;
        int i=0;
     while(xx && i<grid[0].length()){
         for(int j=0 ; j<n;j++ ){
            ll[j]=grid[j].charAt(i);
         }
           
            b=Arrays.copyOf(ll,n);
            Arrays.sort(ll);
            
            if(!(Arrays.equals(b,ll))){
                  xx=false; 
                  break;
            }          
         i++;
    }
       
            if(xx){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
     }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
    
        for (int j = 0; j < x; j++){
             int n = scanner.nextInt();
               String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                String arrItem = scanner.next();
                    char xx[]=arrItem.toCharArray();
                        Arrays.sort(xx);  
                            String string = new String(xx);
                                arr[i] = string ;
            }
                    gridChallenge(arr,n);
         }    
    }
}
