package algorithm.p2581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        boolean[] notPrimes = new boolean[10001];
        notPrimes[1] = true;
        for (int i = 2; i <= 100; i++) {
            if (!notPrimes[i]) {
                for (int j = 2; j * i <= 10000; j++) {
                    notPrimes[i * j] = true;
                }
            }
        }
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int sum = 0;
        int minPrime = Integer.MAX_VALUE;
        for (int i = n; i <= m; i++) {
            if (notPrimes[i]) {
                continue;
            }
            if (minPrime > i) {
                minPrime = i;
            }
            sum += i;
        }
        if (sum == 0) {
            sb.append("-1\n");
            return;
        }
        sb.append(sum).append('\n');
        sb.append(minPrime).append('\n');
    }
}
