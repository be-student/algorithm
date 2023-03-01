package algorithm.leet121;

class Solution {

    public int maxProfit(int[] prices) {
//        int[] minArray = new int[prices.length];
//        int[] maxArray = new int[prices.length];
//        minArray[0] = prices[0];
//        for (int i = 1; i < prices.length; i++) {
//            minArray[i] = Math.min(minArray[i - 1], prices[i]);
//        }
//        maxArray[prices.length - 1] = prices[prices.length - 1];
//        for (int i = prices.length - 2; i >= 0; i--) {
//            maxArray[i] = Math.max(maxArray[i + 1], prices[i]);
//        }
//        int max = 0;
//        for (int i = 0; i < prices.length - 1; i++) {
//            max = Math.max(max, maxArray[i + 1] - minArray[i]);
//        }
//        return max;
        int left = 0;
        int right = 1;
        int maxValue = 0;
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                maxValue = Math.max(maxValue, prices[right] - prices[left]);
                right++;
            } else {
                left = right;
                right++;
            }
        }
        return maxValue;
    }
}