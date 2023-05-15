package algorithm.leet2140;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().mostPoints(new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}}));
    }

    public long mostPoints(int[][] questions) {
        long[] dp = new long[200010];
        for (int i = 0; i < questions.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
            int i1 = i + 2 + questions[i][1];
            dp[i1] = Math.max(dp[i1], dp[i + 1] + questions[i][0]);
        }
        long max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
