import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        long totalSum = 0;
        
        for (int i = 1; i < N; i++) {
            // Step 1: Check Base 10
            if (isPalindrome(Integer.toString(i))) {
                // Step 2 & 3: Convert to Base K and check
                String baseKValue = Integer.toString(i, K);
                if (isPalindrome(baseKValue)) {
                    totalSum += i;
                }
            }
        }
        System.out.println(totalSum);
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
