package algorithm.prognext6;

import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{10, 7, 8, 5, 8, 7, 6, 2, 9}, 3));
    }

    public int solution(int[] prices, int k) {
        // prices: 가격 배열
        // k: 판매해야 하는 일수

        // 저점이라고 생각하는 날에 k 개를 매수하고, 서로 다른 날에 한 주 씩 k 일동안 매도하는 것

        //최대 기대 수익을 반환해주세요
        int answer = -1;

        for (int i = 0; i < prices.length - k; i++) {
            int currentPrice = -prices[i] * k;
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int j = i + 1; j < prices.length; j++) {
                queue.add(prices[j]);
            }
            for (int j = 0; j < k; j++) {
                currentPrice += queue.poll();
            }
            answer = Math.max(answer, currentPrice);

        }

        return answer;
    }
}
