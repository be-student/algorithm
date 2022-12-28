package algorithm.leet1480;

class Solution {

    public int[] runningSum(int[] nums) {
        int sum = 0;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] + sum;
            sum += nums[i];
        }
        return result;
    }
}