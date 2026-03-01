import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limit = 10000;
        int[] bestD = new int[limit + 1];
        
        int maxCycleLen = 0;
        int currentBestD = 3;

        // Precompute best d for every N
        for (int i = 1; i <= limit; i++) {
            int len = getCycleLength(i);
            if (len > maxCycleLen) {
                maxCycleLen = len;
                currentBestD = i;
            }
            bestD[i] = currentBestD;
        }

        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                // We need the best d strictly LESS than n
                System.out.println(bestD[n - 1]);
            }
        }
    }

    private static int getCycleLength(int d) {
        if (d < 2) return 0;
        int[] lastPos = new int[d]; // Tracks at which position a remainder appeared
        int remainder = 1;
        int pos = 1;

        while (remainder != 0 && lastPos[remainder] == 0) {
            lastPos[remainder] = pos++;
            remainder = (remainder * 10) % d;
        }

        return (remainder == 0) ? 0 : pos - lastPos[remainder];
    }
}
