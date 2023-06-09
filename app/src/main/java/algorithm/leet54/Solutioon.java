package algorithm.leet54;

import java.util.ArrayList;
import java.util.List;

public class Solutioon {

    public static void main(String[] args) {
        System.out.println(new Solutioon().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int totalCount = (Math.min(matrix.length, matrix[0].length) + 1) / 2;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < totalCount; i++) {
            for (int j = i; j < matrix[0].length - i - 1; j++) {
                result.add(matrix[i][j]);
            }
            for (int j = i; j < matrix.length - i; j++) {
                result.add(matrix[j][matrix[0].length - 1 - i]);
            }
            for (int j = matrix[0].length - 2; j >= i; j--) {
                result.add(matrix[matrix.length - 1 - i][j]);
            }
            for (int j = matrix.length - 2 - i; j > i; j--) {
                result.add(matrix[j][i]);
            }
        }
        return result;
    }

}
