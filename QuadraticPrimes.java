import java.util.*;

public class Solution {
    // Sieve to quickly check primality
    private static boolean[] isPrime = new boolean[2000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nLimit = sc.nextInt();
        
        sieve(2000000);
        
        int maxPrimes = 0;
        int bestA = 0;
        int bestB = 0;

        // b must be prime and <= N
        for (int b = 2; b <= nLimit; b++) {
            if (!isPrime[b]) continue;

            // a ranges from -N to N. 
            // Based on constraints, we can focus on odd values for a.
            for (int a = -nLimit; a <= nLimit; a++) {
                int count = countConsecutivePrimes(a, b);
                if (count > maxPrimes) {
                    maxPrimes = count;
                    bestA = a;
                    bestB = b;
                }
            }
        }
        System.out.println(bestA + " " + bestB);
    }

    private static int countConsecutivePrimes(int a, int b) {
        int n = 0;
        while (true) {
            int val = n * n + a * n + b;
            if (val < 2 || !isPrime[val]) {
                break;
            }
            n++;
        }
        return n;
    }

    private static void sieve(int max) {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int p = 2; p * p <= max; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= max; i += p)
                    isPrime[i] = false;
            }
        }
    }
}
