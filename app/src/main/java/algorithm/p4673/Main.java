package algorithm.p4673;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final boolean[] checked = new boolean[10001];

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        for (int i = 1; i <= 10000; i++) {
            if (!checked[i]) {
                check(i);
                checked[i] = false;
            }
        }
        for (int i = 1; i <= 10000; i++) {
            if (!checked[i]) {
                sb.append(i).append('\n');
            }
        }
    }

    private void check(int n) {
        if (n > 10000) {
            return;
        }
        checked[n] = true;
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        check(sum);
    }
}
