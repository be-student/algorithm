package algorithm.leet1046;

import java.util.PriorityQueue;

public class Solution {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones) {
            priorityQueue.add(stone);
        }
        while (priorityQueue.size() > 1) {
            Integer first = priorityQueue.poll();
            Integer second = priorityQueue.poll();
            if (first > second) {
                priorityQueue.add(first - second);
            }

        }
        return priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
    }
}
