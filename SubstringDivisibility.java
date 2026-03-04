import java.util.*;

public class Solution {
    static int[] primes = {2, 3, 5, 7, 11, 13, 17};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long totalSum = 0;
        
        int[] digits = new int[N + 1];
        for (int i = 0; i <= N; i++) digits[i] = i;

        // Generate all permutations
        do {
            if (isValid(digits, N)) {
                totalSum += convertToLong(digits);
            }
        } while (nextPermutation(digits));

        System.out.println(totalSum);
    }

    private static boolean isValid(int[] d, int N) {
        // Only check divisibility rules that fit within the 0 to N range
        for (int i = 1; i < N - 1; i++) {
            int num = d[i] * 100 + d[i+1] * 10 + d[i+2];
            if (num % primes[i-1] != 0) return false;
        }
        return true;
    }

    private static long convertToLong(int[] d) {
        long res = 0;
        for (int digit : d) res = res * 10 + digit;
        return res;
    }

    // Standard Next Permutation (Lexicographical) algorithm
    private static boolean nextPermutation(int[] array) {
        int i = array.length - 2;
        while (i >= 0 && array[i] >= array[i + 1]) i--;
        if (i < 0) return false;
        int j = array.length - 1;
        while (array[j] <= array[i]) j--;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        reverse(array, i + 1);
        return true;
    }

    private static void reverse(int[] array, int start) {
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start++] = array[end];
            array[end--] = temp;
        }
    }
}
