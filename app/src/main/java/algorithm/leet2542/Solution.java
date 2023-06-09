package algorithm.leet2542;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    int k;

    public static void main(String[] args) {

    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        this.k = k;
        ArrayDeque<Node> deque = new ArrayDeque<>();

        deque.add(new Node(0, nums2[0]));
        long sum = nums1[0];
        for (int i = 1; i < k - 1; i++) {
            addToPq(deque, nums2[i], i);
            sum = nums1[i];
        }

        long ans = 0;
        for (int i = k - 1; i < nums1.length; i++) {
            addToPq(deque, nums2[i], i);
            sum += nums1[i];
            ans = Math.max(ans, sum * deque.peekFirst().value);
        }
        return ans;
    }

    private void addToPq(Deque<Node> deque, int value, int index) {
        while (!deque.isEmpty()) {
            Node first = deque.peekFirst();
            if (first.value > value) {
                deque.pollFirst();
                continue;
            }
            Node last = deque.peekLast();
            if (last.value >= value) {
                deque.pollLast();
                continue;
            }
            break;
        }
        while (!deque.isEmpty()) {

        }
        deque.addLast(new Node(index, value));
    }
}

class Node {

    int pos;
    int value;

    Node(int pos, int value) {
        this.pos = pos;
        this.value = value;
    }
}
