import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Integer[] perimeters = new Integer[n];
        
        //Store input in perimeters
        for(int i = 0; i < n; i++)
            perimeters[i] = input.nextInt();
        
        //Sort array descending
        Arrays.sort(perimeters, Collections.reverseOrder());
        
        //Check if adjacent triplets are degenerate
        for(int i = 0; i < n-2; i++)
        {
            if(!degenerateTriangle(perimeters[i],perimeters[i+1],perimeters[i+2]))
            {
                System.out.println(perimeters[i+2]+" "+perimeters[i+1]+" "+perimeters[i]);
                System.exit(0);
            }    
        }
        
        //All triangles were degenerative
        System.out.println(-1);
    }
    
    static boolean degenerateTriangle(int a, int b, int c)
    {
        
        if(a+b <= c) return true;
        if(a+c <= b) return true;
        if(b+c <= a) return true;
        return false;
    }
}
