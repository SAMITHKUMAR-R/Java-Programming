import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        Set<Integer> products = new HashSet<>();

        // We only need to check up to certain limits to keep total digits at N
        // For N=9, the product won't exceed 5 digits
        for (int a = 1; a < 10000; a++) {
            for (int b = a; b < 10000; b++) {
                int p = a * b;
                String combined = "" + a + b + p;
                
                if (combined.length() > n) break;
                if (combined.length() == n && isPandigital(combined, n)) {
                    products.add(p);
                }
            }
        }

        long sum = 0;
        for (int p : products) {
            sum += p;
        }
        System.out.println(sum);
    }

    private static boolean isPandigital(String s, int n) {
        if (s.length() != n) return false;
        boolean[] digits = new boolean[n + 1];
        for (char c : s.toCharArray()) {
            int d = c - '0';
            if (d == 0 || d > n || digits[d]) return false;
            digits[d] = true;
        }
        return true;
    }
}
