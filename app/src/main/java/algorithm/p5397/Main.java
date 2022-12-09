package algorithm.p5397;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            Deque<Character> leftDeque = new ArrayDeque<>();
            Deque<Character> rightDeque = new ArrayDeque<>();
            char[] input = br.readLine().toCharArray();
            for (char c : input) {
                switch (c) {
                    case '<':
                        if (!leftDeque.isEmpty()) {
                            rightDeque.addFirst(leftDeque.pollLast());
                        }
                        break;
                    case '>':
                        if (!rightDeque.isEmpty()) {
                            leftDeque.addLast(rightDeque.pollFirst());
                        }
                        break;
                    case '-':
                        if (!leftDeque.isEmpty()) {
                            leftDeque.pollLast();
                        }
                        break;
                    default:
                        leftDeque.addLast(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!rightDeque.isEmpty()) {
                leftDeque.addLast(rightDeque.pollFirst());
            }
            while (!leftDeque.isEmpty()) {
                sb.append(leftDeque.pollFirst());
            }
            System.out.println(sb);
        }
    }
}
