public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Integer [] calories = new Integer[n]; // Use Integer instead of int to make sorting in simpler
        for (int i = 0; i < n; i++){
            calories[i] = scan.nextInt();
        }
        scan.close();
        System.out.println(minimumMiles(calories));
    }
    
    private static long minimumMiles(Integer [] calories) {
        Arrays.sort(calories, Collections.reverseOrder());
        long multiplier = 1;
        long miles = 0;
        for (int j = 0; j < calories.length; j++) {
            miles += calories[j] * multiplier;
            multiplier *= 2;
        }
        return miles;
    }
}
