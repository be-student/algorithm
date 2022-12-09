package algorithm.p1406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        Deque<Character> deque1 = new ArrayDeque<>();
        Deque<Character> deque2 = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (Character character : br.readLine().toCharArray()) {
            deque1.addLast(character);
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String token = br.readLine();
            switch (token.charAt(0)) {
                case 'P':
                    deque1.addLast(token.charAt(2));
                    break;
                case 'L': {
                    if (!deque1.isEmpty()) {
                        deque2.push(deque1.pollLast());
                    }
                    break;
                }
                case 'D': {
                    if (!deque2.isEmpty()) {
                        deque1.addLast(deque2.pop());
                    }
                    break;
                }
                case 'B':
                    if (deque1.isEmpty()) {
                        continue;
                    }
                    deque1.pollLast();
                    break;
            }
        }
        while (!deque2.isEmpty()) {
            deque1.addLast(deque2.pop());
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!deque1.isEmpty()) {
            stringBuilder.append(deque1.pollFirst());
        }
        System.out.println(stringBuilder);
    }
}

