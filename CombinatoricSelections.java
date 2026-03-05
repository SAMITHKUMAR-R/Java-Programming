import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BigInteger K = new BigInteger(sc.next());
        int count = 0;

        // Pascal's Triangle approach to avoid massive factorials
        BigInteger[][] triangle = new BigInteger[N + 1][N + 1];
        for (int n = 0; n <= N; n++) {
            triangle[n][0] = BigInteger.ONE;
            triangle[n][n] = BigInteger.ONE;
            for (int r = 1; r < n; r++) {
                triangle[n][r] = triangle[n - 1][r - 1].add(triangle[n - 1][r]);
                if (triangle[n][r].compareTo(K) > 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
