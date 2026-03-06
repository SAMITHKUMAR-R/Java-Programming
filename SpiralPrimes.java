import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int targetPercent = sc.nextInt();
        
        int primeCount = 0;
        int totalDiagonalCount = 1; // Starting with '1' in the center
        long currentNumber = 1;
        int sideLength = 1;

        while (true) {
            sideLength += 2;
            int step = sideLength - 1;

            // Check the 4 new corners added by this layer
            for (int i = 0; i < 4; i++) {
                currentNumber += step;
                if (i < 3 && isPrime(currentNumber)) { // Bottom-right (i=3) is always a square
                    primeCount++;
                }
            }
            
            totalDiagonalCount += 4;
            
            // Use long to avoid precision issues in ratio calculation
            if ((primeCount * 100L) / totalDiagonalCount < targetPercent) {
                System.out.println(sideLength);
                break;
            }
        }
    }

    // Standard Miller-Rabin or optimized trial division for primality testing
    private static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
