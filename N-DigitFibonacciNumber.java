import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. Precompute results up to 5000 digits
        int[] firstIndexWithNDigits = new int[5001];
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        int index = 2; // F2 is the second '1'
        
        int currentDigitTarget = 2; 
        // 10^(target-1) is the smallest number with that many digits
        BigInteger limit = BigInteger.TEN; 

        while (currentDigitTarget <= 5000) {
            BigInteger next = a.add(b);
            a = b;
            b = next;
            index++;

            // Check if we've reached the next digit threshold
            // b.compareTo(limit) >= 0 is much faster than b.toString().length()
            while (currentDigitTarget <= 5000 && b.compareTo(limit) >= 0) {
                firstIndexWithNDigits[currentDigitTarget] = index;
                currentDigitTarget++;
                limit = limit.multiply(BigInteger.TEN);
            }
        }

        // 2. Handle test cases
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                System.out.println(firstIndexWithNDigits[n]);
            }
        }
        sc.close();
    }
}
