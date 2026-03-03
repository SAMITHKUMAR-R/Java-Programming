import java.util.*;

public class Solution {
    // Pre-calculate factorials for 0-9
    private static final int[] FACTORIALS = new int[10];

    static {
        FACTORIALS[0] = 1;
        for (int i = 1; i < 10; i++) {
            FACTORIALS[i] = FACTORIALS[i - 1] * i;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int N = sc.nextInt();
        
        long totalSum = 0;

        // Problem constraints: 10 <= N <= 10^5
        for (int i = 10; i < N; i++) {
            if (isCurious(i)) {
                totalSum += i;
            }
        }
        System.out.println(totalSum);
    }

    private static boolean isCurious(int n) {
        int sum = 0;
        int temp = n;
        
        // Extract digits and sum their pre-calculated factorials
        while (temp > 0) {
            sum += FACTORIALS[temp % 10];
            temp /= 10;
        }
        
        // Check if the sum of factorials is divisible by the original number
        return sum % n == 0;
    }
}
