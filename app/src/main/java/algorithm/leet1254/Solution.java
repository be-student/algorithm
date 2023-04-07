package algorithm.leet1254;

public class Solution {

    public static void main(String[] args) {
        //[[1,1,1,1,1,1,1],[1,0,0,0,0,0,1],[1,0,1,1,1,0,1],[1,0,1,0,1,0,1],[1,0,1,1,1,0,1],[1,0,0,0,0,0,1],[1,1,1,1,1,1,1]]
//        int[][] input = new int[][]{{1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 1}, {1, 0, 1, 1, 1, 0, 1},
//                {1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 0, 1}, {1, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1}};
        //[[0,0,1,1,0,1,0,0,1,0],[1,1,0,1,1,0,1,1,1,0],[1,0,1,1,1,0,0,1,1,0],[0,1,1,0,0,0,0,1,0,1],[0,0,0,0,0,0,1,1,1,0],[0,1,0,1,0,1,0,1,1,1],[1,0,1,0,1,1,0,0,0,1],[1,1,1,1,1,1,0,0,0,0],[1,1,1,0,0,1,0,1,0,1],[1,1,1,0,1,1,0,1,1,0]]
        int[][] input = new int[][]{{0, 0, 1, 1, 0, 1, 0, 0, 1, 0}, {1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 0, 0, 1, 1, 0}, {0, 1, 1, 0, 0, 0, 0, 1, 0, 1}, {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 1, 0, 1, 0, 1}, {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}};
        int result = new Solution().closedIsland(input);
        System.out.println(result);
    }

    private void connect(int[][] grid, int x, int y, int color) {
        if (x < 0 || x >= grid[0].length) {
            return;
        }
        if (y < 0 || y >= grid.length) {
            return;
        }
        if (grid[y][x] >= 1) {
            return;
        }
        grid[y][x] = color;
        connect(grid, x + 1, y, color);
        connect(grid, x - 1, y, color);
        connect(grid, x, y - 1, color);
        connect(grid, x, y + 1, color);
    }

    public int closedIsland(int[][] grid) {
        int color = 2;
        int xSize = grid[0].length;
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                connect(grid, 0, i, color);
            }
            if (grid[i][xSize - 1] == 0) {
                connect(grid, xSize - 1, i, color);
            }
        }
        for (int i = 0; i < xSize; i++) {
            if (grid[0][i] == 0) {
                connect(grid, i, 0, color);
            }
            if (grid[grid.length - 1][i] == 0) {
                connect(grid, i, grid.length - 1, color);
            }
        }
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < xSize - 1; j++) {
                if (grid[i][j] == 0) {
                    answer++;
                    connect(grid, j, i, color++);
                }
            }
        }
        return answer;
    }
}
