package algorithm.leet2439;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().minimizeArrayValue(new int[]{3, 7, 1, 6}));
    }

    public int minimizeArrayValue(int[] nums) {
        long[] sumArray = new long[nums.length];
        sumArray[0] = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            sumArray[i + 1] = sumArray[i] + nums[i + 1];
        }
        long max = sumArray[0];
        for (int i = 1; i < nums.length; i++) {
            max = (int) Math.max(max, Math.ceil((double) sumArray[i] / (i + 1)));
        }
        return (int) max;
    }
}
