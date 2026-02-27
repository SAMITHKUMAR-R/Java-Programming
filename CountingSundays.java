import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        
        while (t-- > 0) {
            long y1 = sc.nextLong();
            int m1 = sc.nextInt();
            int d1 = sc.nextInt();
            
            long y2 = sc.nextLong();
            int m2 = sc.nextInt();
            int d2 = sc.nextInt();
            
            // Move to the first "1st of the month" in or after the start date
            if (d1 > 1) {
                m1++;
                if (m1 > 12) {
                    m1 = 1;
                    y1++;
                }
            }
            
            int count = 0; // MUST be inside the loop
            while (y1 < y2 || (y1 == y2 && m1 <= m2)) {
                if (getDayOfWeek(y1, m1, 1) == 1) { // 1 is Sunday in Zeller's
                    count++;
                }
                m1++;
                if (m1 > 12) {
                    m1 = 1;
                    y1++;
                }
            }
            System.out.println(count);
        }
    }

    private static int getDayOfWeek(long y, int m, int d) {
        if (m < 3) {
            m += 12;
            y--;
        }
        long k = y % 100;
        long j = y / 100;
        
        // Zeller's formula: h is the day of the week
        // 0=Sat, 1=Sun, 2=Mon, 3=Tue, 4=Wed, 5=Thu, 6=Fri
        long h = (d + (13 * (m + 1)) / 5 + k + (k / 4) + (j / 4) + (5 * j)) % 7;
        
        return (int) ((h + 7) % 7); // Ensure positive remainder
    }
}
