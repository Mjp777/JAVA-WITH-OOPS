import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Map<Integer,Integer> sequenceFunction = new HashMap<>();
        for(int i = 1; i <= n; i++)
        {
            sequenceFunction.put(input.nextInt(),i);
        }
        
        for(int i = 1; i <= n; i++){
            int x = i;
            int t = sequenceFunction.get(x);
            int y = sequenceFunction.get(t);
            System.out.println(y);
        }
    }
}
