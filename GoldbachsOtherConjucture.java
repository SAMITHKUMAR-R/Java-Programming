import java.io.*;
import java.util.*;

public class Solution {
    
    private static final int MAX = 500000;
    private static boolean[] isPrime = new boolean[MAX + 1];

    public static void main(String[] args) {
        // Step 1: Pre-calculate primes using Sieve
        sieve();

        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int T = sc.nextInt();
            while (T-- > 0) {
                int N = sc.nextInt();
                System.out.println(countWays(N));
            }
        }
    }

    private static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int p = 2; p * p <= MAX; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= MAX; i += p)
                    isPrime[i] = false;
            }
        }
    }

    private static int countWays(int n) {
        int count = 0;
        // Step 2: Iterate through k such that 2*k^2 < n
        for (int k = 1; ; k++) {
            int twoKSquared = 2 * k * k;
            if (twoKSquared >= n) break;
            
            int p = n - twoKSquared;
            // Step 3: Check if the remaining part is prime
            if (isPrime[p]) {
                count++;
            }
        }
        return count;
    }
}
