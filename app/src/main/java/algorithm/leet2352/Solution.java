package algorithm.leet2352;

public class Solution {

    int answer = 0;

    public static void main(String[] args) {
        System.out.println(
                new Solution().equalPairs(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}));
    }

    public int equalPairs(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int[] line = new int[grid.length];
                for (int k = 0; k < grid.length; k++) {
                    line[k] = grid[i][k];
                }
                int equalCount = 0;
                for (int k = 0; k < grid.length; k++) {
                    if (line[k] == grid[k][j]) {
                        equalCount++;
                    }
                }
                if (equalCount == grid.length) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
