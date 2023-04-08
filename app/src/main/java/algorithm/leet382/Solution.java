package algorithm.leet382;

import java.util.ArrayList;
import java.util.List;

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {

    private final List<Integer> list;

    public Solution(ListNode head) {
        list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        int randomChoice = (int) (Math.random() * list.size());
        return list.get(randomChoice);
    }
}
