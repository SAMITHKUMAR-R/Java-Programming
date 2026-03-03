import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int N = sc.nextInt();

        // 1. Sieve of Eratosthenes up to 1,000,000
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
        // Start from 11 because 2, 3, 5, 7 are excluded
        for (int i = 11; i < N; i++) {
            if (isPrime[i] && isTruncatable(i, isPrime)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    private static boolean isTruncatable(int n, boolean[] isPrime) {
        // Truncate from Right (remove last digit)
        int tempR = n / 10;
        while (tempR > 0) {
            if (!isPrime[tempR]) return false;
            tempR /= 10;
        }

        // Truncate from Left (remove first digit)
        String s = Integer.toString(n);
        for (int i = 1; i < s.length(); i++) {
            int tempL = Integer.parseInt(s.substring(i));
            if (!isPrime[tempL]) return false;
        }

        return true;
    }
}
