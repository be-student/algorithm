package algorithm.leet413;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{-1, -2, -3}));
        System.out.println(numberOfArithmeticSlices(new int[]{7, 7, 7, 7}));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        //차이가 0인거, 1인거, 2인거, 3인거, ... 1000인것 까지 보면 될듯
        Set<String> checked = new HashSet<>();

        var count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int diff = nums[i] - nums[i + 1];
            for (int j = 2; i + j < nums.length; j++) {
                if (nums[i + j - 1] - nums[i + j] != diff) {
                    break;
                }

                var sb = new StringBuilder();
                for (int k = i; k <= i + j; k++) {
                    sb.append(k);
                }
                String result = sb.toString();
                if (!checked.contains(result)) {
                    checked.add(result);
                    count++;
                }
            }
        }
        return count;
    }
}
