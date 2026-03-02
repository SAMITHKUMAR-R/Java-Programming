import java.util.*;

public class Solution {
    private static final int MOD = 1000000007;
    private static final int MAX_N = 100000;
    private static long[] dp = new long[MAX_N + 1];

    public static void main(String[] args) {
        // Pre-calculate the DP table
        precompute();

        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            sb.append(dp[n]).append("\n");
        }
        // Using StringBuilder for faster output with 10^4 test cases
        System.out.print(sb.toString());
    }

    private static void precompute() {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= MAX_N; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % MOD;
            }
        }
    }
}
