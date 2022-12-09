package algorithm.p11279;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int item = Integer.parseInt(br.readLine());
            if (item == 0) {
                if (queue.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else {
                queue.offer(item);
            }
        }
        System.out.println(sb);
    }
}