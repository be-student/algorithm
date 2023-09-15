package algorithm.prognext1;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("1451232125", 2));
    }

    public int solution(String s, int N) {
        int answer = -1;
        for (int i = 0; i < s.length() - N + 1; i++) {
            Set<Integer> integers = new HashSet<>();
            for (int j = 0; j < N; j++) {
                integers.add(s.charAt(i + j) - '0');
            }
            boolean isRight = true;
            for (int j = 1; j <= N; j++) {
                if (!integers.contains(j)) {
                    isRight = false;
                    break;
                }
            }
            if (isRight) {
                answer = Math.max(answer, Integer.parseInt(s.substring(i, i + N)));
            }
        }
        return answer;
    }
}
