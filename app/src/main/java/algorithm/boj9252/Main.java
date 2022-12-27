package algorithm.boj9252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final int dp[][] = new int[1001][1001];

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1] != s2[j - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    continue;
                }
                dp[i][j] = dp[i - 1][j - 1] + 1;
            }
        }
        sb.append(dp[s1.length][s2.length]).append('\n');
        StringBuilder sb2 = new StringBuilder();
        int currentY = s1.length;
        int currentX = s2.length;
        while (currentY > 0 && currentX > 0) {
            if (dp[currentY][currentX] == dp[currentY - 1][currentX]) {
                currentY--;
            } else if (dp[currentY][currentX] == dp[currentY][currentX - 1]) {
                currentX--;
            } else {
                sb2.insert(0, s1[currentY - 1]);
                currentY--;
                currentX--;
            }
        }
        sb.append(sb2);
    }
}
