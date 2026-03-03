import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int N = sc.nextInt();

        // 1. Sieve of Eratosthenes up to 1,000,000
        // Rotations can exceed N, so we sieve up to a safe margin or handle rotations carefully
        boolean[] isPrime = new boolean[1000000];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int p = 2; p * p < 1000000; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i < 1000000; i += p)
                    isPrime[i] = false;
            }
        }

        long sum = 0;
        for (int i = 2; i < N; i++) {
            if (isCircularPrime(i, isPrime)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    private static boolean isCircularPrime(int n, boolean[] isPrime) {
        String s = Integer.toString(n);
        
        // Optimization: if any digit is even or 5 (and n > 5), 
        // one of its rotations will not be prime.
        if (n > 5) {
            for (char c : s.toCharArray()) {
                int digit = c - '0';
                if (digit % 2 == 0 || digit == 5) return false;
            }
        }

        // Check all rotations
        for (int i = 0; i < s.length(); i++) {
            if (!isPrime[Integer.parseInt(s)]) return false;
            // Rotate string: move first char to end
            s = s.substring(1) + s.charAt(0);
        }
        return true;
    }
}
