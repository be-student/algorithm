package algorithm.p2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final boolean[] checked = new boolean[1111];
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;
        for (var i = 2; i <= n; i++) {
            if (checked[i]) {
                continue;
            }
            for (int j = 1; j * i <= n; j++) {
                if (!checked[j * i]) {
                    count++;
                    if (count == k) {
                        sb.append(j * i);
                        return;
                    }
                    checked[i * j] = true;
                }
            }
        }
    }
}
