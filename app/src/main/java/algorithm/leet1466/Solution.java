package algorithm.leet1466;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<Edge>> graph = new ArrayList<>();
    boolean[] visited;


    public static void main(String[] args) {
        var result = new Solution().minReorder(3, new int[][]{{1, 0}, {2, 0}});
        System.out.println(result);
    }

    public int minReorder(int n, int[][] connections) {
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (var connection : connections) {
            graph.get(connection[0]).add(new Edge(connection[0], connection[1], true));
            graph.get(connection[1]).add(new Edge(connection[1], connection[0], false));
        }
        return dfs(0);
    }

    private int dfs(int i) {
        visited[i] = true;
        int result = 0;
        for (var edge : graph.get(i)) {
            if (!visited[edge.to]) {
                result += edge.isReversed ? 1 : 0;
                result += dfs(edge.to);
            }
        }
        return result;
    }
}

class Edge {

    int from;
    int to;
    boolean isReversed;

    Edge(int from, int to, boolean isReversed) {
        this.from = from;
        this.to = to;
        this.isReversed = isReversed;
    }
}
