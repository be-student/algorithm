package algorithm.p6198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        long result = 0;
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());
            while (!deque.isEmpty() && deque.peekLast() <= height) {
                deque.pollLast();
            }
            result += deque.size();
            deque.addLast(height);
        }
        sb.append(result);
    }
}
