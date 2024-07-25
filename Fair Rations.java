import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
               
        int bread = 0;
        int currentBread = 0;
        
        for(int i = 0; i < N; i++)
        {
            currentBread += in.nextInt();
            if(i == N-1)//We have reached the last person
            {
                if(currentBread % 2 == 1) //If last person ended with odd bread it is not possible
                {
                    System.out.println("NO");
                    System.exit(0);
                }
                else
                {
                    System.out.println(bread);
                    System.exit(0);
                }
            }
            
            
            if(currentBread % 2 == 1) //The current person has odd bread give them and the next person bread
            {
                currentBread = 1;
                bread += 2;
                continue;
            }
            currentBread = 0; // No extra bread was given out
        }
        
    }
}
