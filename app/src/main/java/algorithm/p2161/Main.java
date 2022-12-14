/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package algorithm.p2161;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = IntStream.rangeClosed(1, n)
                .boxed().collect(Collectors.toCollection(LinkedList::new));
        StringBuilder sb = new StringBuilder();
        while (deque.size() > 1) {
            sb.append(deque.poll());
            sb.append(' ');
            int temp = deque.poll();
            deque.addLast(temp);
        }

        sb.append(deque.poll());
        System.out.println(sb);
    }
}
