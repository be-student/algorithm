package algorithm.boj10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final int[][] dp = new int[2001][2001];
    private int[] arr;

    public static void main(String[] args) throws IOException {
        new Main().solution();
        System.out.println(sb);
    }

    private void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int result = palindrome(s - 1, e - 1);
            if (result == 1) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
    }

    private int palindrome(int s, int e) {
        if (s >= e) {
            return 1;
        }
        if (dp[s][e] != 0) {
            return dp[s][e];
        }
        if (arr[s] != arr[e]) {
            return dp[s][e] = -1;
        }
        return dp[s][e] = palindrome(s + 1, e - 1);
    }
}
