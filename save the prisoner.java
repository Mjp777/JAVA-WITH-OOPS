import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int S = scan.nextInt();
            int last = ((S - 1) + (M - 1)) % N + 1;
            System.out.println(last);
        }
        scan.close();
    }
}
