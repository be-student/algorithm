package algorithm.leet2348;

public class Solution {

    private final long[] results = new long[100000];

    public static void main(String[] args) {
        //[1,3,0,0,2,0,0,4]
        System.out.println(new Solution().zeroFilledSubarray(new int[]{1, 3, 0, 0, 2, 0, 0, 4}));
    }

    public long zeroFilledSubarray(int[] nums) {
        results[1] = 1;
        results[2] = 3;
        long answer = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
            } else {
                answer += count(count);
                count = 0;
            }
        }
        answer += count(count);
        return answer;
    }

    private long count(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 3;
        }
        if (results[n] != 0) {
            return results[n];
        }
        long count = count(n - 1) + n;
        results[n] = count;
        return count;
    }
}
