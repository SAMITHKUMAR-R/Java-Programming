import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        for (int i = 125874; i <= N; i++) {
            if (checkPermutations(i, K)) {
                for (int m = 1; m <= K; m++) {
                    System.out.print((long)i * m + (m == K ? "" : " "));
                }
                System.out.println();
            }
        }
    }

    private static boolean checkPermutations(int x, int K) {
        int[] baseCounts = getDigitCounts(x);
        for (int m = 2; m <= K; m++) {
            if (!Arrays.equals(baseCounts, getDigitCounts(x * m))) {
                return false;
            }
        }
        return true;
    }

    private static int[] getDigitCounts(int n) {
        int[] counts = new int[10];
        while (n > 0) {
            counts[n % 10]++;
            n /= 10;
        }
        return counts;
    }
}
