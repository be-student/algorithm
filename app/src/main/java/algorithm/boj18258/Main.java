package algorithm.boj18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        int T = Integer.parseInt(br.readLine());
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int t = 0; t < T; t++) {
            doLogic(linkedList);
        }

    }

    private void doLogic(LinkedList<Integer> linkedList) throws IOException {
        String[] split = br.readLine()
                .split(" ");
        String keyword = split[0];
        if (keyword.equals("push")) {
            linkedList.addFirst(Integer.parseInt(split[1]));
        } else if (keyword.equals("size")) {
            sb.append(linkedList.size())
                    .append("\n");
        } else if (keyword.equals("front")) {
            if (linkedList.size() == 0) {
                sb.append("-1\n");
            } else {
                sb.append(linkedList.get(linkedList.size() - 1))
                        .append("\n");
            }
        } else if (keyword.equals("back")) {
            if (linkedList.size() == 0) {
                sb.append(-1)
                        .append("\n");
            } else {
                sb.append(linkedList.get(0))
                        .append("\n");
            }
        } else if (keyword.equals("pop")) {
            if (linkedList.size() == 0) {
                sb.append(-1)
                        .append("\n");
            } else {
                sb.append(linkedList.removeLast())
                        .append("\n");
            }
        } else if (keyword.equals("empty")) {
            if (linkedList.size() == 0) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
    }
}
