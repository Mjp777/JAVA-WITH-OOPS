import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine().trim();
        scan.close();
        String[] tokens=s.split("[ !,?._'@]+");
        System.out.println(tokens.length);
        for(String token:tokens)
        {
            System.out.println(token);
        }
    }
}
