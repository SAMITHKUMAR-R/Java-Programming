import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int N = sc.nextInt();
        BigInteger totalSum = BigInteger.ZERO;
        BigInteger modulo = new BigInteger("10000000000"); // 10^10

        for (int i = 1; i <= N; i++) {
            BigInteger val = BigInteger.valueOf(i);
            // Compute (i^i) % 10^10
            totalSum = totalSum.add(val.modPow(val, modulo));
        }

        // Final result modulo 10^10
        System.out.println(totalSum.mod(modulo));
    }
}
