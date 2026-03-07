import java.util.*;

public class Solution {
    static Map<Integer, List<Integer>> polygonalMap = new HashMap<>();
    static TreeSet<Integer> resultSums = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int k = sc.nextInt();
        int[] types = new int[k];
        for (int i = 0; i < k; i++) {
            types[i] = sc.nextInt();
            polygonalMap.put(types[i], generate4DigitNumbers(types[i]));
        }

        // Start with the first type provided in the input
        boolean[] used = new boolean[k];
        used[0] = true;

        for (int num : polygonalMap.get(types[0])) {
            List<Integer> chain = new ArrayList<>();
            chain.add(num);
            findCycle(num, num, types, used, chain);
        }

        for (int sum : resultSums) System.out.println(sum);
    }

    private static void findCycle(int start, int last, int[] types, boolean[] used, List<Integer> chain) {
        if (chain.size() == types.length) {
            if (last % 100 == start / 100) {
                int sum = 0;
                for (int n : chain) sum += n;
                resultSums.add(sum);
            }
            return;
        }

        int suffix = last % 100;
        if (suffix < 10) return; // Next number must be 4-digit (1000+)

        for (int i = 0; i < types.length; i++) {
            if (!used[i]) {
                for (int nextNum : polygonalMap.get(types[i])) {
                    if (nextNum / 100 == suffix) {
                        used[i] = true;
                        chain.add(nextNum);
                        findCycle(start, nextNum, types, used, chain);
                        chain.remove(chain.size() - 1);
                        used[i] = false;
                    }
                }
            }
        }
    }

    private static List<Integer> generate4DigitNumbers(int s) {
        List<Integer> list = new ArrayList<>();
        int n = 1, val = 0;
        while (val < 10000) {
            switch (s) {
                case 3: val = n * (n + 1) / 2; break;
                case 4: val = n * n; break;
                case 5: val = n * (3 * n - 1) / 2; break;
                case 6: val = n * (2 * n - 1); break;
                case 7: val = n * (5 * n - 3) / 2; break;
                case 8: val = n * (3 * n - 2); break;
            }
            if (val >= 1000 && val <= 9999) list.add(val);
            n++;
        }
        return list;
    }
}
