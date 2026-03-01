import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        // Precompute factorials up to 13!
        long[] factorials = new long[14];
        factorials[0] = 1;
        for (int i = 1; i <= 13; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        while (t-- > 0) {
            long n = sc.nextLong() - 1; // Convert to 0-indexed
            String s = "abcdefghijklm";
            List<Character> chars = new ArrayList<>();
            for (char c : s.toCharArray()) chars.add(c);

            StringBuilder result = new StringBuilder();
            
            // Determine each character from left to right
            for (int i = 12; i >= 0; i--) {
                int index = (int) (n / factorials[i]);
                result.append(chars.get(index));
                chars.remove(index); // Remove used character
                n %= factorials[i];  // Remainder for next iteration
            }
            System.out.println(result.toString());
        }
        sc.close();
    }
}
