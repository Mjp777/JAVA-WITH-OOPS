import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), arr[] = new int[n], sum = 0;;
        for(int i=0;i<n;i++)        arr[i] = sc.nextInt();
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i=0;i<n;i++)    freqMap.put(arr[i],freqMap.getOrDefault(arr[i], 0) + 1 );
        for(int value : freqMap.values())       sum+= value/2;
        System.out.println(sum);
    }
}
