import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        for (int m = 2; m < N; m++) {
            if (isPandigitalMultiple(m, K)) {
                System.out.println(m);
            }
        }
    }

    private static boolean isPandigitalMultiple(int m, int K) {
        StringBuilder sb = new StringBuilder();
        int n = 1;
        
        // Keep multiplying and concatenating
        while (sb.length() < K) {
            sb.append(m * n);
            n++;
        }
        
        // Must be exactly K digits long
        if (sb.length() != K) {
            return false;
        }
        
        return isPandigital(sb.toString(), K);
    }

    private static boolean isPandigital(String s, int K) {
        if (s.length() != K) return false;
        
        boolean[] seen = new boolean[K + 1];
        for (char c : s.toCharArray()) {
            int digit = c - '0';
            // Check if digit is in range 1 to K and not repeated
            if (digit < 1 || digit > K || seen[digit]) {
                return false;
            }
            seen[digit] = true;
        }
        return true;
    }
}
