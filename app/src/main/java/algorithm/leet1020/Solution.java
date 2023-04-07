package algorithm.leet1020;

public class Solution {

    private int answer = 0;

    public static void main(String[] args) {
        //[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
        int result = new Solution().numEnclaves(new int[][]{
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        });
        System.out.println(result);
    }

    public int numEnclaves(int[][] grid) {
        int xSize = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) {
                connect(grid, 0, i, 0);
            }
            if (grid[i][xSize - 1] == 1) {
                connect(grid, xSize - 1, i, 0);
            }
        }
        for (int i = 0; i < xSize; i++) {
            if (grid[0][i] == 1) {
                connect(grid, i, 0, 0);
            }
            if (grid[grid.length - 1][i] == 1) {
                connect(grid, i, grid.length - 1, 0);
            }
        }
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < xSize - 1; j++) {
                if (grid[i][j] == 1) {
                    connect(grid, j, i, 1);
                }
            }
        }
        return answer;
    }

    private void connect(int[][] grid, int x, int y, int count) {
        if (x < 0 || x >= grid[0].length) {
            return;
        }
        if (y < 0 || y >= grid.length) {
            return;
        }
        if (grid[y][x] == 0 || grid[y][x] == 2) {
            return;
        }
        grid[y][x] = 2;
        answer += count;
        connect(grid, x + 1, y, count);
        connect(grid, x - 1, y, count);
        connect(grid, x, y - 1, count);
        connect(grid, x, y + 1, count);
    }
}
