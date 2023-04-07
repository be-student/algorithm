package algorithm.leet881;

public class Solution {

    public static void main(String[] args) {
        int result = new Solution().numRescueBoats(new int[]{5, 1, 4, 2}, 6);
        System.out.println(result);
    }

    public int numRescueBoats(int[] people, int limit) {
        int[] count = new int[limit + 1];
        for (int person : people) {
            count[person]++;
        }
        int ans = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            for (int j = limit - i; j >= 0; j--) {
                if (count[j] == 0) {
                    continue;
                }
                count[j]--;
                break;
            }
            count[i]--;
            if (count[i] > 0) {
                i--;
            }
            ans++;
        }
        return ans;
    }
}
