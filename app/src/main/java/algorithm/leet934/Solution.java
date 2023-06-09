package algorithm.leet934;

public class Solution {

    int answer = -1;
    boolean[][] visited;

    private void bfs() {

    }

    public int shortestBridge(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        return answer;
    }
}

class Node {

    int count;
    int x;
    int y;

    public Node(int count, int x, int y) {
        this.count = count;
        this.x = x;
        this.y = y;
    }
}
