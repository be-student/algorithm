package algorithm.p11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        Queue<Study> queue = new PriorityQueue<>();
        int currentTime = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            queue.offer(new Study(start, end));
        }
        Queue<Integer> now = new PriorityQueue<>();

        while (!queue.isEmpty()) {
            Study fastest = queue.poll();
            currentTime = fastest.startTime;
            while (!now.isEmpty() && now.peek() <= currentTime) {
                now.poll();
            }
            now.offer(fastest.endTime);
            max = Math.max(max, now.size());
        }
        sb.append(max);
    }
}

class Study implements Comparable<Study> {

    public final int startTime;
    public final int endTime;

    public Study(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Study o) {
        if (startTime == o.startTime) {
            return Integer.compare(o.endTime, endTime);
        }
        return Integer.compare(startTime, o.startTime);
    }
}