import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int T = sc.nextInt();
            while (T-- > 0) {
                long product = 1;
                for (int i = 0; i < 7; i++) {
                    product *= getDigit(sc.nextLong());
                }
                System.out.println(product);
            }
        }
    }

    public static long getDigit(long n) {
        long length = 1; // Current number of digits (1, 2, 3...)
        long count = 9;  // How many numbers exist with this length
        long start = 1;  // The first number of this length (1, 10, 100...)

        // Step 1: Find the range
        while (n > length * count) {
            n -= length * count;
            length++;
            count *= 10;
            start *= 10;
        }

        // Step 2: Find the exact number
        long targetNumber = start + (n - 1) / length;
        
        // Step 3: Extract the specific digit
        String s = Long.toString(targetNumber);
        return s.charAt((int)((n - 1) % length)) - '0';
    }
}
