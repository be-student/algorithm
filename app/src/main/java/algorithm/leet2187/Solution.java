package algorithm.leet2187;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumTime(new int[]{1, 2, 3}, 5));
    }

    public long minimumTime(int[] time, int totalTrips) {
        long left = 0;
        long right = 1000000000000000L;
        long result = 0;
        while (left < right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int i : time) {
                count += mid / i;
            }
            if (count >= totalTrips) {
                result = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
