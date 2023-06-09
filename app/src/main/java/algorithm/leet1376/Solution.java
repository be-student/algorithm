package algorithm.leet1376;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private final Map<Integer, List<Integer>> edges = new HashMap<>();
    int[] informTime;
    int answer;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.informTime = informTime;
        for (int to = 0; to < manager.length; to++) {
            int from = manager[to];
            if (from == -1) {
                continue;
            }
            List<Integer> edgeArray = edges.getOrDefault(from, new ArrayList<>());
            edgeArray.add(to);
            edges.put(from, edgeArray);
        }
        dfs(headID, 0);

        return answer;
    }

    private void dfs(int start, int currentTime) {
        answer = Math.max(answer, currentTime);

        List<Integer> edgeArray = edges.getOrDefault(start, new ArrayList<>());
        for (int to : edgeArray) {
            dfs(to, currentTime + informTime[start]);
        }
    }
}
