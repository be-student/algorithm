package algorithm.p5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private Deque<Integer> deque = new ArrayDeque<>();
    private char[] commands;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            init();
            doSomething();
        }
    }

    private void init() throws IOException {
        commands = br.readLine().toCharArray();
        int n = Integer.parseInt(br.readLine());
        deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
        for (int i = 0; i < n; i++) {
            deque.add(Integer.parseInt(st.nextToken()));
        }
    }

    private void doSomething() {
        boolean startFront = true;
        for (char command : commands) {
            if (command == 'R') {
                startFront = !startFront;
            } else if (command == 'D') {
                if (deque.isEmpty()) {
                    System.out.println("error");
                    return;
                }
                if (startFront) {
                    deque.pollFirst();
                } else {
                    deque.pollLast();
                }
            }
        }
        print(startFront);
    }

    private void print(boolean startFront) {
        StringBuilder sb = new StringBuilder().append('[');
        if (deque.size() > 0) {
            if (startFront) {
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            } else {
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }

        }
        System.out.println(sb.append(']'));
    }
}