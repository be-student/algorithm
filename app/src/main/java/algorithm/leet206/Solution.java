package algorithm.leet206;

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

class Solution {

    public ListNode reverseList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode copied = head;
        while (copied != null) {
            list.add(copied.val);
            copied = copied.next;
        }
        copied = head;
        for (int i = list.size() - 1; i >= 0; i--) {
            copied.val = list.get(i);
            copied = copied.next;
        }
        return head;
    }
}