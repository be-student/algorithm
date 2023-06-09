package algorithm.leet347;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new Solution().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (var num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Node> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (var entry : map.entrySet()) {
            Node e = new Node(entry.getKey(), entry.getValue());
            queue.add(e);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().value;
        }
        return result;
    }
}

class Node implements Comparable<Node> {

    int value;
    int count;

    public Node(int value, int count) {
        this.value = value;
        this.count = count;
    }

    @Override
    public int compareTo(Node o) {
        return count - o.count;
    }
}
