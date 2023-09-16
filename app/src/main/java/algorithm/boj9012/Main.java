package algorithm.boj9012;

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
        for (int t = 0; t < T; t++) {
            String string = br.readLine();
            LinkedList<Character> linkedList = new LinkedList<>();
            doLogic(string, linkedList);
        }
    }

    private void doLogic(String string, LinkedList<Character> linkedList) {
        for (char c : string.toCharArray()) {
            if (c == ')') {
                if (linkedList.isEmpty()) {
                    sb.append("NO")
                            .append("\n");
                    return;
                } else {
                    linkedList.removeLast();
                }
            } else {
                linkedList.add('(');
            }
        }
        if (linkedList.isEmpty()) {
            sb.append("YES")
                    .append("\n");
        } else {
            sb.append("NO")
                    .append("\n");
        }
    }
}
