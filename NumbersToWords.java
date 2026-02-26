import java.io.*;
import java.util.*;

public class Solution {
    private static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] thousands = {"", "Thousand", "Million", "Billion", "Trillion"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            if (n == 0) {
                System.out.println("Zero");
                continue;
            }
            System.out.println(numberToWords(n).trim());
        }
    }

    private static String numberToWords(long n) {
        String res = "";
        int i = 0;
        while (n > 0) {
            if (n % 1000 != 0) {
                res = helper((int)(n % 1000)) + thousands[i] + " " + res;
            }
            n /= 1000;
            i++;
        }
        return res;
    }

    private static String helper(int n) {
        if (n == 0) return "";
        else if (n < 20) return units[n] + " ";
        else if (n < 100) return tens[n / 10] + " " + helper(n % 10);
        else return units[n / 100] + " Hundred " + helper(n % 100);
    }
}
