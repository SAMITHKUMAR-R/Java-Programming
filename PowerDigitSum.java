import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            
            while (t-- > 0) {
                int n = sc.nextInt();
                
                BigInteger power = BigInteger.valueOf(2).pow(n);
                
                String s = power.toString();
                int sum = 0;
                
                for (int i = 0; i < s.length(); i++) {
                    sum += s.charAt(i) - '0';
                }
                
                System.out.println(sum);
            }
        }
        sc.close();
    }
}
