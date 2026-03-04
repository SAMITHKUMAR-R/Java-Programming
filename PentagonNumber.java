import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        long[] pentagons = new long[N];
        for (int i = 1; i < N; i++) {
            pentagons[i] = (long) i * (3L * i - 1) / 2;
        }

        for (int n = K + 1; n < N; n++) {
            long Pn = pentagons[n];
            long Pnk = pentagons[n - K];
            
            // Check Pn - Pnk or Pn + Pnk
            if (isPentagonal(Pn - Pnk) || isPentagonal(Pn + Pnk)) {
                System.out.println(Pn);
            }
        }
    }

    private static boolean isPentagonal(long x) {
        if (x <= 0) return false;
        // Solving 3n^2 - n - 2x = 0
        long discriminant = 1 + 24 * x;
        long sqrtD = (long) Math.sqrt(discriminant);
        
        if (sqrtD * sqrtD != discriminant) return false;
        return (1 + sqrtD) % 6 == 0;
    }
}
