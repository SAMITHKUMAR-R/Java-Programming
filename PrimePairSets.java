import java.util.*;

public class Solution {
    private static List<Integer> primes = new ArrayList<>();
    private static Map<Integer, Set<Integer>> adj = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int N = sc.nextInt();
        int K = sc.nextInt();

        // 1. Sieve of Eratosthenes to find primes up to N
        boolean[] isP = new boolean[N];
        Arrays.fill(isP, true);
        isP[0] = isP[1] = false;
        for (int p = 2; p * p < N; p++) {
            if (isP[p]) {
                for (int i = p * p; i < N; i += p) isP[i] = false;
            }
        }
        for (int i = 2; i < N; i++) {
            if (isP[i]) primes.add(i);
        }

        // 2. Build adjacency map for pairs that satisfy the property
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                if (isPair(primes.get(i), primes.get(j))) {
                    adj.computeIfAbsent(i, k -> new HashSet<>()).add(j);
                }
            }
        }

        // 3. Use backtracking to find cliques of size K
        List<Long> results = new ArrayList<>();
        findCliques(new ArrayList<>(), 0, K, results);
        
        Collections.sort(results);
        for (long sum : results) {
            System.out.println(sum);
        }
    }

    private static void findCliques(List<Integer> current, int start, int K, List<Long> results) {
        if (current.size() == K) {
            long sum = 0;
            for (int idx : current) sum += primes.get(idx);
            results.add(sum);
            return;
        }

        for (int i = start; i < primes.size(); i++) {
            boolean canAdd = true;
            for (int idx : current) {
                if (!adj.getOrDefault(idx, new HashSet<>()).contains(i)) {
                    canAdd = false;
                    break;
                }
            }
            if (canAdd) {
                current.add(i);
                findCliques(current, i + 1, K, results);
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isPair(int a, int b) {
        return isPrime(Long.parseLong(a + "" + b)) && isPrime(Long.parseLong(b + "" + a));
    }

    private static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n < 4) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
