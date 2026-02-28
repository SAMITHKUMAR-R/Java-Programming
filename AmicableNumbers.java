import java.util.*;

public class Solution {
    private static final int MAX = 100001;
    private static int[] divisorSum = new int[MAX];
    private static int[] amicablePrefixSum = new int[MAX];

    public static void main(String[] args) {
        precompute();
        
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                // We need sum of amicable numbers UNDER n
                System.out.println(amicablePrefixSum[n - 1]);
            }
        }
    }

    private static void precompute() {
        // Step 1: Sieve to find sum of proper divisors
        // We start from 1 because 1 is a proper divisor of all i > 1
        Arrays.fill(divisorSum, 1);
        divisorSum[0] = 0;
        divisorSum[1] = 0;

        for (int i = 2; i * 2 < MAX; i++) {
            for (int j = i * 2; j < MAX; j += i) {
                divisorSum[j] += i;
            }
        }

        // Step 2 & 3: Find amicable numbers and build prefix sum
        int currentSum = 0;
        for (int i = 1; i < MAX; i++) {
            int b = divisorSum[i];
            
            // Condition for amicable pair: d(a) == b AND d(b) == a AND a != b
            if (b < MAX && b != i && divisorSum[b] == i) {
                currentSum += i;
            }
            amicablePrefixSum[i] = currentSum;
        }
    }
}
