package algorithm.leet1721;

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public static void main(String[] args) {
//        head = [1,2,3,4,5], k = 2
        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i = 2; i <= 5; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }
        ListNode listNode = new Solution().swapNodes(head, 2);
        System.out.println(listNode);
    }

    public ListNode swapNodes(ListNode head, int k) {
        int totalLength = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            totalLength++;
        }
        ListNode first = head;
        for (int i = 0; i < k - 1; i++) {
            first = first.next;
        }
        ListNode second = head;
        for (int i = 0; i < totalLength - k; i++) {
            second = second.next;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
}
