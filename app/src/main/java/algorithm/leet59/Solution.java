package algorithm.leet59;

public class Solution {

    public int[][] generateMatrix(int n) {
        int totalCount = (n + 1) / 2;
        int[][] matrix = new int[n][n];

        int temp = 1;
        for (int i = 0; i < totalCount; i++) {
            for (int j = i; j < matrix[0].length - i; j++) {
                matrix[i][j] = temp++;
            }
            for (int j = i + 1; j < matrix.length - i; j++) {
                matrix[j][matrix[0].length - 1 - i] = temp++;
            }
            for (int j = matrix[0].length - 2 - i; j >= i && matrix.length - 1 - i != i; j--) {
                matrix[matrix.length - 1 - i][j] = temp++;
            }
            for (int j = matrix.length - 2 - i; j > i && matrix[0].length - 1 - i != i; j--) {
                matrix[j][i] = temp++;
            }
        }
        return matrix;
    }
}
