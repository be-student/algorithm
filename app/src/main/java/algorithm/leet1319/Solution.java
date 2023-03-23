package algorithm.leet1319;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private final List<List<Integer>> edge = new ArrayList<>();

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            edge.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            edge.get(connection[0]).add(connection[1]);
            edge.get(connection[1]).add(connection[0]);
        }
        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited);
                ans++;
            }
        }
        return ans - 1;
    }

    private void dfs(int u, boolean[] visited) {
        visited[u] = true;
        for (int v : edge.get(u)) {
            if (!visited[v]) {
                dfs(v, visited);
            }
        }
    }
}
