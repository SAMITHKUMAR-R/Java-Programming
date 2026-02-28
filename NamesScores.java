import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Step 1: Read input names
        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }
        
        // Step 2: Sort names alphabetically
        Arrays.sort(names);
        
        // Step 3: Calculate scores and store in a Map
        Map<String, Long> scoreMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long alphaValue = calculateAlphaValue(names[i]);
            long totalScore = alphaValue * (i + 1); // (i + 1) for 1-based indexing
            scoreMap.put(names[i], totalScore);
        }
        
        // Step 4: Process queries
        int q = sc.nextInt();
        while (q-- > 0) {
            String queryName = sc.next();
            System.out.println(scoreMap.getOrDefault(queryName, 0L));
        }
    }
    
    private static long calculateAlphaValue(String name) {
        long sum = 0;
        for (char c : name.toCharArray()) {
            // 'A' is 65 in ASCII, so 'A' - 'A' + 1 = 1
            sum += (c - 'A' + 1);
        }
        return sum;
    }
}
