import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        
        // We only need to check bases from 1 to 9
        for (int x = 1; x <= 9; x++) {
            // Calculate x^n
            double power = Math.pow(x, n);
            
            // Check the number of digits
            // A number 'v' has floor(log10(v)) + 1 digits
            // However, for n=19, Math.pow can lose precision.
            // Better to use long for exactness or check the range:
            // 10^(n-1) <= x^n < 10^n
            
            if (hasNDigits(x, n)) {
                // Since the sample output shows results in ascending order,
                // printing x^n for x=1 to 9 will naturally be sorted.
                printPower(x, n);
            }
        }
    }
    
    private static boolean hasNDigits(int x, int n) {
        // Using BigInteger to be safe against overflow for n=19
        java.math.BigInteger base = java.math.BigInteger.valueOf(x);
        java.math.BigInteger res = base.pow(n);
        return res.toString().length() == n;
    }
    
    private static void printPower(int x, int n) {
        java.math.BigInteger base = java.math.BigInteger.valueOf(x);
        System.out.println(base.pow(n));
    }
}
