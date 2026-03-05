import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int N = sc.nextInt();

        // Map to store: Palindrome -> Count of numbers converging to it
        Map<BigInteger, Integer> convergenceMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            BigInteger current = BigInteger.valueOf(i);
            BigInteger resultPalindrome = findPalindrome(current);
            
            if (resultPalindrome != null) {
                convergenceMap.put(resultPalindrome, convergenceMap.getOrDefault(resultPalindrome, 0) + 1);
            }
        }

        // Find the palindrome with the maximum count
        BigInteger maxPalindrome = BigInteger.ZERO;
        int maxCount = -1;

        for (Map.Entry<BigInteger, Integer> entry : convergenceMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxPalindrome = entry.getKey();
            } else if (entry.getValue() == maxCount) {
                // If counts are equal, usually the smaller palindrome is preferred, 
                // but check problem specifics. Here we prioritize the first found.
                if (entry.getKey().compareTo(maxPalindrome) < 0) {
                    maxPalindrome = entry.getKey();
                }
            }
        }

        System.out.println(maxPalindrome + " " + maxCount);
    }

    private static BigInteger findPalindrome(BigInteger n) {
        // Special case: palindromes are non-lychrel in 0th iteration
        if (isPalindrome(n)) return n;

        BigInteger temp = n;
        for (int i = 0; i < 60; i++) {
            BigInteger reversed = new BigInteger(new StringBuilder(temp.toString()).reverse().toString());
            temp = temp.add(reversed);
            if (isPalindrome(temp)) {
                return temp;
            }
        }
        return null; // Assumed Lychrel
    }

    private static boolean isPalindrome(BigInteger n) {
        String s = n.toString();
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) return false;
        }
        return true;
    }
}
