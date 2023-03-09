package algorithm.leet142;

import java.util.HashSet;
import java.util.Set;

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (nodes.contains(head)) {
                return head;
            }
            nodes.add(head);
            head = head.next;
        }
        return null;
    }
}
