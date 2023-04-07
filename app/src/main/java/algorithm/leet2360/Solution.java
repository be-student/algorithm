package algorithm.leet2360;

public class Solution {

    private final boolean[] visited = new boolean[100001];

    public int longestCycle(int[] edges) {
        int n = edges.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            int slow = i;
            while (slow != -1 && !visited[slow]) {
                visited[slow] = true;
                slow = edges[slow];
            }
            if (slow == -1) {
                continue;
            }
            int fast = edges[slow];
            int add = 1;
            while (fast != slow) {
                if (fast == -1) {
                    break;
                }
                fast = edges[fast];
                add++;
            }
            if (fast != -1) {
                ans = Math.max(ans, add);
            }
        }

        return (ans == 0) ? -1 : ans;
    }
}
