import java.util.*;

public class Solution {
    private static int[] cache = new int[5000001];
    private static int[] longestStart = new int[5000001];

    public static void main(String[] args) {
        precompute();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(longestStart[n]);
        }
    }

    private static void precompute() {
        int maxLen = 0;
        int bestStart = 0;
        cache[1] = 1;

        for (int i = 1; i <= 5000000; i++) {
            int len = getChainLength(i);
            if (len >= maxLen) { 
                maxLen = len;
                bestStart = i;
            }
            longestStart[i] = bestStart;
        }
    }

    private static int getChainLength(long n) {
        if (n <= 5000000 && cache[(int)n] != 0) return cache[(int)n];
        
        int len;
        if (n % 2 == 0) len = 1 + getChainLength(n / 2);
        else len = 1 + getChainLength(3 * n + 1);
        
        if (n <= 5000000) cache[(int)n] = len;
        return len;
    }
}
