import java.util.*;

public class Solution {
    private static final int LIMIT = 100001;
    private static boolean[] isSumOfTwo = new boolean[LIMIT];

    public static void main(String[] args) {
        precompute();
        
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                if (n >= LIMIT) {
                    // Mathematical analysis shows all numbers > 28123 can 
                    // be written as the sum of two abundant numbers.
                    System.out.println("YES");
                } else {
                    System.out.println(isSumOfTwo[n] ? "YES" : "NO");
                }
            }
        }
    }

    private static void precompute() {
        int[] divisorSum = new int[LIMIT];
        Arrays.fill(divisorSum, 1);
        divisorSum[0] = 0;
        divisorSum[1] = 0;

        // Sieve to find sum of proper divisors
        for (int i = 2; i * 2 < LIMIT; i++) {
            for (int j = i * 2; j < LIMIT; j += i) {
                divisorSum[j] += i;
            }
        }

        // Collect all abundant numbers
        List<Integer> abundantNumbers = new ArrayList<>();
        for (int i = 1; i < LIMIT; i++) {
            if (divisorSum[i] > i) {
                abundantNumbers.add(i);
            }
        }

        // Mark all sums of two abundant numbers
        for (int i = 0; i < abundantNumbers.size(); i++) {
            for (int j = i; j < abundantNumbers.size(); j++) {
                int sum = abundantNumbers.get(i) + abundantNumbers.get(j);
                if (sum < LIMIT) {
                    isSumOfTwo[sum] = true;
                } else {
                    // Since the list is sorted, we can break early
                    break;
                }
            }
        }
    }
}
