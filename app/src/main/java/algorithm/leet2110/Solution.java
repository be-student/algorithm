package algorithm.leet2110;

public class Solution {

    public static void main(String[] args) {
        System.out.println(getDescentPeriods(new int[]{3, 2, 1, 4}));
    }

    public static long getDescentPeriods(int[] prices) {
        //10 만까지 가능
        long[] dp = new long[prices.length];
        dp[prices.length - 1] = 1;
        var result = 1L;
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] - 1 == prices[i + 1]) {
                dp[i] = dp[i + 1] + 1;
            } else {
                dp[i] = 1;
            }
            result += dp[i];
        }
        return result;
    }
}
