package algorithm.boj1935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        int T = Integer.parseInt(br.readLine());
        String line = br.readLine();
        List<Integer> operands = new ArrayList<>();
        for (int t = 0; t < T; t++) {
            operands.add(Integer.parseInt(br.readLine()));
        }
        char[] charArray = line.toCharArray();
        List<String> strings = new ArrayList<>();
        for (char c : charArray) {
            if ('A' <= c && c <= 'Z') {
                strings.add(operands.get(c - 'A')
                        .toString());
            } else {
                strings.add(String.valueOf(c));
            }
        }
        Deque<Double> deque = new ArrayDeque<>();
        for (String string : strings) {
            if (isOperand(string)) {
                double second = deque.pop();
                double first = deque.pop();
                double result = 0;
                switch (string) {
                    case "*":
                        result = first * second;
                        break;
                    case "-":
                        result = first - second;
                        break;
                    case "/":
                        result = first / second;
                        break;
                    case "+":
                        result = first + second;
                        break;
                }
                deque.push(result);
            } else {
                deque.push(Double.parseDouble(string));
            }
        }
        sb.append(String.format("%.2f", deque.pop()));
    }

    private boolean isOperand(String other) {
        return other.equals("*") || other.equals("-") || other.equals("/") || other
                .equals("+");
    }
}
