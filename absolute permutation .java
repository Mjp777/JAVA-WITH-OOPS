import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



public class Solution {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int k = in.nextInt();

            if (k == 0) {
                for (int i = 1; i <= n; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
            } else if (n % 2 == 0 && n % (2 * k) == 0) {
                int blocks = n / k;
                int currentNumber = k;
                for (int i = 0; i < blocks; i++) {
                    for (int j = 0; j < k; j++) {
                        currentNumber++;
                        System.out.print(currentNumber + " ");

                    }
                    if (i % 2 != 0) {
                        currentNumber = currentNumber + (2 * k);
                    } else {
                        currentNumber = currentNumber - (2 * k);
                    }
                }
                System.out.println();
            } else {
                System.out.println(-1);
            }

        }
    }                
}
