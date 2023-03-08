package algorithm.leet875;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minEatingSpeed(new int[]{1000000000, 1000000000}, 3));
    }

    public int minEatingSpeed(int[] piles, int h) {
        long left = 1;
        long right = 10000000000L;
        long result = 0;
        while (left < right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int i : piles) {
                count += i / mid;
                if (i % mid != 0) {
                    count++;
                }
            }
            if (count <= h) {
                result = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) result;
    }
}
