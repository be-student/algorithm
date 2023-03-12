package algorithm.leet23;

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

    private ListNode[] lists;

    public ListNode mergeKLists(ListNode[] lists) {
        this.lists = lists;
        ListNode head = new ListNode();
        ListNode current = head;
        while (!finish()) {
            int minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (minIndex == -1) {
                    minIndex = i;
                    continue;
                }
                if (lists[minIndex].val > lists[i].val) {
                    minIndex = i;
                }
            }
            current.next = lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
            current = current.next;
        }
        return head.next;
    }

    private boolean finish() {
        for (ListNode list : lists) {
            if (list != null) {
                return false;
            }
        }
        return true;
    }
}
