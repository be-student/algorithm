package algorithm.prognext5;

public class Solution {

    public static void main(String[] args) {
        //        10, 10, 3, 2, 7, [[2, 2], [2, 3], [2, 4], [6, 2], [6, 3], [6, 4], [3, 5]]
        System.out.println(new Solution().solution(10, 10, 3, 2, 7,
                new int[][]{{2, 2}, {2, 3}, {2, 4}, {6, 2}, {6, 3}, {6, 4}, {3, 5}}));
    }

    public int solution(int A, int B, int C, int D, int N, int[][] Chips) {
        // 케이크: A cm x B cm
        // 직사각형 틀: C cm x D cm
        // 직사각형을 회전시킬 수도 있음
        // 초콜릿 칩: N개
        // 초콜릿 칩의 좌표 xn, yn: (Chips[n-1][0], Chips[n-1][1])
        int answer = 0;
        long[][] sum = new long[A + 1][B + 1];
        for (int i = 0; i < N; i++) {
            sum[Chips[i][0]][Chips[i][1]]++;
        }
        for (int i = 1; i <= A; i++) {
            for (int j = 1; j <= B; j++) {
                sum[i][j] += sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }
        for (int i = C + 1; i <= A; i++) {
            for (int j = D + 1; j <= B; j++) {
                long count = sum[i][j] - sum[i - C - 1][j] - sum[i][j - D - 1] + sum[i - C - 1][j - D - 1];
                answer = Math.max(answer, (int) count);
            }
        }
        // 직사각형을 회전시킬 수도 있음
        for (int i = D + 1; i <= A; i++) {
            for (int j = C + 1; j <= B; j++) {
                long count = sum[i][j] - sum[i - D - 1][j] - sum[i][j - C - 1] + sum[i - D - 1][j - C - 1];
                answer = Math.max(answer, (int) count);
            }
        }
        return answer;
    }
}
