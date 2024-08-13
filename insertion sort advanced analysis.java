import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] ar = new int[n];
            for (int j = 0; j < n; j++) {
                ar[j] = in.nextInt();
                //System.err.println(ar[j]);
            }
            long c = insertSort(ar);
            System.out.println(c);
        }
    }

    static long count = 0;

    public static void mergesort(int[] arr, int p, int r) {
        int q = (p + r) / 2;
        if (p < r) {
            mergesort(arr, p, q);
            mergesort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    public static void merge(int[] arr, int p, int q, int r) {
        int[] left = new int[q - p + 1];
        int[] right = new int[r - q];
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[p + i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[q + i + 1];
        }

        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    arr[k] = left[i];
                    i++;
                } else {
                    arr[k] = right[j];
                    count += left.length - i;
                    j++;
                }
            } else {
                if (i < left.length) {
                    arr[k] = left[i];
                    i++;
                } else if (j < right.length) {
                    arr[k] = right[j];
                    j++;
                }
            }
        }
    }

    public static long insertSort(int[] ar) {
        count = 0;
        mergesort(ar, 0, ar.length - 1);
        return count;

    }
}
