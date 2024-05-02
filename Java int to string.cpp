

import java.io.*;
import java.util.*;

public class Solution {

public static void main(String[] args) 
{
    Scanner tc = new Scanner (System.in);
    int n;
    n= tc.nextInt();
    if (n < 100 || n > -100 )
    {
        String nString = "" + n;
        System.out.print ("Good job");
    }
    else 
    {
        System.out.print ("Wrong answer");
    }


}
}
