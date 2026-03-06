import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        int maxDigitSum = 0;

        // Iterate through all bases a < N
        for (int a = 1; a < n; a++) {
            BigInteger base = BigInteger.valueOf(a);
            
            // Iterate through all exponents b < N
            for (int b = 1; b < n; b++) {
                // Calculate a^b
                BigInteger power = base.pow(b);
                
                // Calculate the sum of its digits
                int currentSum = getDigitSum(power);
                
                if (currentSum > maxDigitSum) {
                    maxDigitSum = currentSum;
                }
            }
        }
        
        System.out.println(maxDigitSum);
    }

    // Helper method to sum digits of a BigInteger
    private static int getDigitSum(BigInteger number) {
        String s = number.toString();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }
        return sum;
    }
}
