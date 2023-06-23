package algorithm.leet1027;

public class Solution {

    public int longestArithSeqLength(int[] nums) {
        int[][] dp = new int[nums.length][20001];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            for (int j = 0; j < i; j++) {
                int previous = nums[j];
                int diff = current - previous + 10000;
                dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
                ans = Math.max(ans, dp[i][diff]);
            }
        }
        return ans + 1;
    }
}
