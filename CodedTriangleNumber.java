import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Handle T test cases
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                if (sc.hasNextLong()) {
                    long tn = sc.nextLong();
                    solve(tn);
                }
            }
        }
    }

    private static void solve(long tn) {
        // Equation: n(n+1)/2 = tn  =>  n^2 + n - 2tn = 0
        // Quadratic Formula: n = (-1 + sqrt(1 + 8tn)) / 2
        
        // Use 8.0 to force double precision for the initial check
        // for tn = 10^18, val can be 8 * 10^18 (fits in unsigned long, but be careful)
        // We use a safe check for the discriminant: D = 1 + 8*tn
        
        long discriminant = 1 + 8 * tn;
        long root = (long) Math.sqrt(discriminant);

        // Check if it's a perfect square and if n is an integer
        if (root * root == discriminant) {
            // n must be (-1 + root) / 2
            if ((root - 1) % 2 == 0) {
                long n = (root - 1) / 2;
                System.out.println(n);
            } else {
                System.out.println("-1");
            }
        } else {
            // Check adjacent values due to potential double precision issues at 10^18
            if ((root + 1) * (root + 1) == discriminant) {
                long newRoot = root + 1;
                System.out.println((newRoot - 1) / 2);
            } else {
                System.out.println("-1");
            }
        }
    }
}
