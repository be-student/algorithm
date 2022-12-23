package algorithm.boj17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int[][][] dp;

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 2][n + 2];
        dp = new int[n + 2][n + 2][3];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][2][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == 1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                    dp[i][j][2] = 0;
                }
                if (arr[i][j + 1] == 0) {
                    dp[i][j + 1][0] += dp[i][j][0] + dp[i][j][2];
                }
                if (arr[i + 1][j] == 0) {
                    dp[i + 1][j][1] += dp[i][j][2] + dp[i][j][1];
                }
                if (arr[i][j + 1] == 0 && arr[i + 1][j] == 0 && arr[i + 1][j + 1] == 0) {
                    dp[i + 1][j + 1][2] += dp[i][j][0] + dp[i][j][1] + dp[i][j][2];
                }
            }
        }
        sb.append(dp[n][n][0] + dp[n][n][1] + dp[n][n][2]);
    }
}
