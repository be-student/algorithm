package algorithm.p4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final boolean[] isChecked = new boolean[250001];

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        isChecked[1] = true;
        for (int i = 2; i <= 250000; i++) {
            if (isChecked[i]) {
                continue;
            }
            for (int j = 2; j * i <= 250000; j++) {
                isChecked[i * j] = true;
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                return;
            }
            int result = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isChecked[i] == false) {
                    result++;
                }
            }
            sb.append(result).append("\n");
        }
    }
}
