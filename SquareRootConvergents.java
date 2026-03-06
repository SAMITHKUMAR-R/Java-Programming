import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int N = sc.nextInt();
        
        // Initial values for the first iteration (3/2)
        BigInteger num = BigInteger.valueOf(3);
        BigInteger den = BigInteger.valueOf(2);
        
        // We start from 1 to N expansions
        for (int i = 1; i <= N; i++) {
            // Check if numerator has more digits than denominator
            if (num.toString().length() > den.toString().length()) {
                System.out.println(i);
            }
            
            // Calculate next iteration using the recurrence relation
            // Temporary storage for current num to calculate next den
            BigInteger nextNum = num.add(den.multiply(BigInteger.valueOf(2)));
            BigInteger nextDen = num.add(den);
            
            num = nextNum;
            den = nextDen;
        }
    }
}
