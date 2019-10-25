package org.sorel.leetcode.p0024;

import org.sorel.leetcode.structures.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            ListNode node1 = prev.next, node2 = prev.next.next;
            node1.next = node2.next;
            node2.next = node1;
            prev.next = node2;
            prev = node1;
        }
        return dummy.next;
    }
}
