package algorithm.leet1498;

import java.util.Arrays;
import java.util.List;

public class Solution {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        System.out.println(new Solution().numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));
    }

    public int numSubseq(int[] nums, int target) {
        List<Integer> sorted = Arrays.stream(nums).sorted().boxed().toList();

        long result = 0;
        for (int i = 0; i < sorted.size(); i++) {
            result = (result + pow(count(sorted, i, target))) % MOD;
        }
        return (int) result;
    }

    private int count(List<Integer> sortedList, int start, int target) {
        int left = start;
        int right = sortedList.size() - 1;
        int result = -1;
        while (left <= right) {

            int startValue = sortedList.get(start);
            int mid = (left + right) / 2;
            int sum = startValue + sortedList.get(mid);

            if (sum <= target) {
                result = mid - start;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private long pow(int totalCount) {
        if (totalCount == -1) {
            return 0;
        }
        if (totalCount == 0) {
            return 1;
        }
        if (totalCount == 1) {
            return 2;
        }
        if (totalCount % 2 == 1) {
            int current = totalCount / 2;
            long pow = pow(current);
            long result = pow * pow * 2;
            return (int) (result % MOD);
        }
        int current = totalCount / 2;
        long pow = pow(current);
        long result = pow * pow;
        return result % MOD;
    }
}
