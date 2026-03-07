import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        int K = sc.nextInt();

        Map<String, List<Long>> map = new HashMap<>();
        // Iterate until n^3 exceeds N
        for (long n = 1; ; n++) {
            long cube = n * n * n;
            if (cube >= N) break; 
            
            char[] chars = String.valueOf(cube).toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(cube);
        }

        List<Long> results = new ArrayList<>();
        for (List<Long> list : map.values()) {
            if (list.size() == K) results.add(list.get(0));
        }
        
        Collections.sort(results);
        for (long res : results) System.out.println(res);
    }
}
