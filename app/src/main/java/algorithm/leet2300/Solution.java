package algorithm.leet2300;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        var result = new Solution().successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7);
        System.out.println(Arrays.toString(result));
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int left = 0;
            int right = potions.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if ((long) spells[i] * potions[mid] < success) {
                    left = mid + 1;
                    continue;
                }
                right = mid - 1;
            }
            result[i] = potions.length - left;
        }
        return result;
    }
}
