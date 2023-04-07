package algorithm.leet983;

public class Solution {

    private final int[] cache = new int[800];

    public static void main(String[] args) {
        var result = new Solution().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15});
        System.out.println(result);
    }

    public int mincostTickets(int[] days, int[] costs) {
        for (int i = 1; i < 800; i++) {
            cache[i] = 1000000000;
        }
        for (int i = 0; i < 400; i++) {
            cache[i + 1] = Math.min(cache[i + 1], cache[i] + costs[0]);
            cache[i + 7] = Math.min(cache[i + 7], cache[i] + costs[1]);
            cache[i + 30] = Math.min(cache[i + 30], cache[i] + costs[2]);
        }
        for (int i = 400; i >= 0; i--) {
            cache[i] = Math.min(cache[i], cache[i + 1]);
        }
        int answer = 0;
        for (int day : days) {
            answer = cache[day];
        }
        return answer;
    }
}
