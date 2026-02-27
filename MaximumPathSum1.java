import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int t = sc.nextInt(); // Number of test cases
        
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of rows
            int[][] triangle = new int[n][n];
            
            // Fill the triangle
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    triangle[i][j] = sc.nextInt();
                }
            }
            
            // Bottom-up Dynamic Programming
            for (int i = n - 2; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    // Update current cell with the max of its two children
                    triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
                }
            }
            
            // The result is stored at the peak
            System.out.println(triangle[0][0]);
        }
        sc.close();
    }
}
