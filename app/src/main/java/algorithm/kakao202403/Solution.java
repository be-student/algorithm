package algorithm.kakao202403;

import java.util.Arrays;

public class Solution {

    int[] answer;
    int maxSum = 0;
    private int[][] dice;

    public static void main(String[] args) {
        //[[1, 2, 3, 4, 5, 6], [3, 3, 3, 3, 4, 4], [1, 3, 3, 4, 4, 4], [1, 1, 4, 4, 5, 5]]
        System.out.println(Arrays.toString(new Solution().solution(new int[][]{
                {1, 2, 3, 4, 5, 6},
                {3, 3, 3, 3, 4, 4},
                {1, 3, 3, 4, 4, 4},
                {1, 1, 4, 4, 5, 5}
        })));
    }

    public int[] solution(int[][] dice) {
        this.dice = dice;
        int[] trace = new int[dice.length];
        answer = new int[dice.length / 2];
        boolean[] visited = new boolean[dice.length];
        for (int i = 0; i < trace.length; i++) {
            trace[i] = i;
        }
        combination(trace, visited, 0, trace.length, trace.length / 2);

        return answer;
    }

    public void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            checkAnswer(arr, visited);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    private void checkAnswer(int[] arr, boolean[] visited) {
        int[] aVisited = new int[dice.length / 2];
        int[] bVisited = new int[dice.length / 2];
        int aIndex = 0;
        int bIndex = 0;
        for (int i = 0; i < dice.length; i++) {
            if (visited[i]) {
                aVisited[aIndex++] = arr[i];
            } else {
                bVisited[bIndex++] = arr[i];
            }
        }
        checkAnswer(aVisited, bVisited);
    }

    private void checkAnswer(int[] aVisited, int[] bVisited) {
        //1,2 3,4 같이 반반 쪼개짐
        //이기는 경우가 몇개인지 세면 됨. 그 결과가 현재 maxSum보다 크면 answer과 maxSum을 갱신
        int[][] dpA = new int[aVisited.length + 1][1000]; //dpA[i][j] : i번째 주사위까지 사용해서 j를 만들 수 있는 경우의 수
        int[][] dpB = new int[bVisited.length + 1][1000]; //dpB[i][j] : i번째 주사위까지 사용해서 j를 만들 수 있는 경우의 수
        dpA[0][0] = 1;
        dpB[0][0] = 1;
        for (int i = 1; i <= aVisited.length; i++) {
            for (int j = 0; j < 1000; j++) {
                if (dpA[i - 1][j] > 0) {
                    dpA[i][j + dice[aVisited[i - 1]][0]] += dpA[i - 1][j];
                    dpA[i][j + dice[aVisited[i - 1]][1]] += dpA[i - 1][j];
                    dpA[i][j + dice[aVisited[i - 1]][2]] += dpA[i - 1][j];
                    dpA[i][j + dice[aVisited[i - 1]][3]] += dpA[i - 1][j];
                    dpA[i][j + dice[aVisited[i - 1]][4]] += dpA[i - 1][j];
                    dpA[i][j + dice[aVisited[i - 1]][5]] += dpA[i - 1][j];
                }
            }
        }
        for (int i = 1; i <= bVisited.length; i++) {
            for (int j = 0; j < 1000; j++) {
                if (dpB[i - 1][j] > 0) {
                    dpB[i][j + dice[bVisited[i - 1]][0]] += dpB[i - 1][j];
                    dpB[i][j + dice[bVisited[i - 1]][1]] += dpB[i - 1][j];
                    dpB[i][j + dice[bVisited[i - 1]][2]] += dpB[i - 1][j];
                    dpB[i][j + dice[bVisited[i - 1]][3]] += dpB[i - 1][j];
                    dpB[i][j + dice[bVisited[i - 1]][4]] += dpB[i - 1][j];
                    dpB[i][j + dice[bVisited[i - 1]][5]] += dpB[i - 1][j];
                }
            }
        }
        int aWinCount = 0;
        for (int i = 0; i < 501; i++) {
            for (int j = 0; j < i; j++) {
                if (dpA[aVisited.length][i] > 0 && dpB[bVisited.length][j] > 0) {
                    aWinCount += dpA[aVisited.length][i] * dpB[bVisited.length][j];
                }
            }
        }
        if (aWinCount > maxSum) {
            maxSum = aWinCount;
            for (int i = 0; i < aVisited.length; i++) {
                answer[i] = aVisited[i] + 1;
            }
        }
    }
}
