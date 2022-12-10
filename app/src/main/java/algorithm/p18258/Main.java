/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package algorithm.p18258;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String token = st.nextToken();
            Integer item;
            switch (token) {
                case "push":
                    deque.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    item = deque.poll();
                    if (item == null) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(item).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        sb.append("1\n");
                        break;
                    }
                    sb.append("0\n");
                    break;
                case "front":
                    item = deque.peek();
                    if (item == null) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(item).append("\n");
                    break;
                case "back":
                    item = deque.peekLast();
                    if (item == null) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(item).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}