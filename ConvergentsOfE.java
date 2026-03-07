import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.hasNextInt() ? sc.nextInt() : 100;
        
        // n=1 is a special case (the first term is just 2)
        if (n == 1) {
            System.out.println(2);
            return;
        }

        // 1. Generate the sequence of coefficients a_i for the continued fraction
        int[] a = new int[n];
        a[0] = 2;
        for (int i = 1; i < n; i++) {
            if (i % 3 == 2) {
                a[i] = 2 * (i / 3 + 1);
            } else {
                a[i] = 1;
            }
        }

        // 2. Work backward to find the numerator of the n-th convergent
        // Calculation: n_prev / d_prev = a[i] + 1 / (n_curr / d_curr)
        BigInteger numerator = BigInteger.valueOf(a[n - 1]);
        BigInteger denominator = BigInteger.ONE;

        for (int i = n - 2; i >= 0; i--) {
            BigInteger temp = numerator;
            // Add the next term: a[i] + (denominator / numerator)
            numerator = BigInteger.valueOf(a[i]).multiply(numerator).add(denominator);
            denominator = temp;
        }

        // 3. Sum the digits of the final numerator
        System.out.println(sumDigits(numerator));
    }

    private static int sumDigits(BigInteger n) {
        String s = n.toString();
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        return sum;
    }
}
