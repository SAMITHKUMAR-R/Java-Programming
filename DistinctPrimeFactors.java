import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        // The upper limit needs to cover N and the consecutive integers following it
        // Since we check sequences starting at i <= N, the range extends to N + K
        int limit = N + K;
        int[] factorCount = new int[limit + 1];

        // Modified Sieve to count distinct prime factors
        for (int i = 2; i <= limit; i++) {
            if (factorCount[i] == 0) { // i is prime
                for (int j = i; j <= limit; j += i) {
                    factorCount[j]++;
                }
            }
        }

        // Find sequences of K consecutive integers with K distinct factors
        for (int i = 2; i <= N; i++) {
            boolean match = true;
            for (int j = 0; j < K; j++) {
                if (factorCount[i + j] != K) {
                    match = false;
                    break;
                }
            }
            if (match) {
                System.out.println(i);
            }
        }
    }
}
