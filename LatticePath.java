import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long[][] dp = new long[501][501];
        int mod = 1000000007;
        for (int i = 0; i <= 500; i++) {
            dp[i][0] = 1;
            dp[0][i] = 1;
        }
        for (int i = 1; i <= 500; i++) {
            for (int j = 1; j <= 500; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
            }
        }
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(dp[n][m]);
        }
    }
}
