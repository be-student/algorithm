package algorithm.leet1920;

class Solution {

    private int[] result;

    public int[] buildArray(int[] nums) {
        result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }
}