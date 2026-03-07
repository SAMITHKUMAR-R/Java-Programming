import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int N = sc.nextInt();
        
        int oddPeriodCount = 0;

        for (int n = 2; n <= N; n++) {
            int limit = (int) Math.sqrt(n);
            // Skip perfect squares
            if (limit * limit == n) continue;

            int periodLength = getPeriodLength(n, limit);
            if (periodLength % 2 != 0) {
                oddPeriodCount++;
            }
        }
        
        System.out.println(oddPeriodCount);
    }

    private static int getPeriodLength(int n, int a0) {
        int m = 0;
        int d = 1;
        int a = a0;
        int length = 0;

        // The period of the continued fraction expansion starts 
        // when a becomes 2 * a0
        while (a != 2 * a0) {
            m = d * a - m;
            d = (n - m * m) / d;
            a = (a0 + m) / d;
            length++;
        }
        return length;
    }
}
