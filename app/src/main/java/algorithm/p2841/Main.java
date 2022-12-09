package algorithm.p2841;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final Map<Integer, Queue<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 6; i++) {
            map.put(i, new PriorityQueue<>(Comparator.reverseOrder()));
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int result = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Queue<Integer> now = map.get(a);
            while (!now.isEmpty() && now.peek() > b) {
                result++;
                now.poll();
            }
            if (now.isEmpty() || (!now.isEmpty() && !now.peek().equals(b))) {
                result++;
                now.offer(b);
            }
        }
        System.out.println(result);
    }
}
