package algorithm.p5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Set<String> set = new HashSet<>();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String value = br.readLine();
                list.add(value);
                set.add(value);
            }
            boolean printYes = true;
            for (int i = 0; i < n; i++) {
                String value = list.get(i);
                for (int j = 1; j < value.length(); j++) {
                    String sub = value.substring(0, j);
                    if (set.contains(sub)) {
                        sb.append("NO").append('\n');
                        printYes = false;
                        break;
                    }
                }
                if (!printYes) {
                    break;
                }
            }
            if (printYes) {
                sb.append("YES").append('\n');
            }
        }
    }
}
