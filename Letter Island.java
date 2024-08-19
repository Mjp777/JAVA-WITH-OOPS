import java.util.HashSet;
import java.util.Set;

public class Islands {
    
    public static void main(String[] args) {
        String s = "abaab"; // example input
        int k = 2; // example input
        
        System.out.println(countSubstringsWithKIslands(s, k));
    }
    
    public static int countSubstringsWithKIslands(String s, int k) {
        Set<String> uniqueSubstrings = new HashSet<>();
        int n = s.length();
        
        // Generate all possible substrings
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String substring = s.substring(i, j);
                int islands = countIslands(s, substring);
                if (islands == k) {
                    uniqueSubstrings.add(substring);
                }
            }
        }
        
        return uniqueSubstrings.size();
    }
    
    private static int countIslands(String s, String t) {
        boolean[] marked = new boolean[s.length()];
        int islandCount = 0;
        int n = s.length();
        int m = t.length();
        
        // Mark positions where the substring t appears
        for (int i = 0; i <= n - m; i++) {
            if (s.substring(i, i + m).equals(t)) {
                for (int j = i; j < i + m; j++) {
                    marked[j] = true;
                }
            }
        }
        
        // Count the number of islands
        boolean inIsland = false;
        for (int i = 0; i < n; i++) {
            if (marked[i]) {
                if (!inIsland) {
                    inIsland = true;
                    islandCount++;
                }
            } else {
                inIsland = false;
            }
        }
        
        return islandCount;
    }
}
