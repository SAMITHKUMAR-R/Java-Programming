import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        System.out.println(countDistinctPowers(n));
    }

    private static long countDistinctPowers(int n) {
        boolean[] visitedBase = new boolean[n + 1];
        long totalDistinct = 0;
        
        // Max power any base can have such that base^maxPower <= n
        int maxPowerLimit = (int) (Math.log(n) / Math.log(2));
        
        // Pre-calculate how many unique exponents exist for a chain of length 'p'
        // This avoids redundant calculations for every base
        int[] uniqueExponentsPerChain = new int[maxPowerLimit + 1];
        for (int p = 1; p <= maxPowerLimit; p++) {
            Set<Integer> exponents = new HashSet<>();
            for (int i = 1; i <= p; i++) {
                for (int b = 2; b <= n; b++) {
                    exponents.add(i * b);
                }
            }
            uniqueExponentsPerChain[p] = exponents.size();
        }

        for (int a = 2; a <= n; a++) {
            if (visitedBase[a]) continue;

            int chainLength = 0;
            long temp = a;
            while (temp <= n) {
                visitedBase[(int)temp] = true;
                chainLength++;
                if (n / a < temp) break; // Avoid overflow
                temp *= a;
            }
            
            totalDistinct += uniqueExponentsPerChain[chainLength];
        }
        
        return totalDistinct;
    }
}
