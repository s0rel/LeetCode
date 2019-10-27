package org.sorel.leetcode.p0086;

import org.sorel.leetcode.structures.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode less = left;
        ListNode greater = right;
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        greater.next = null;
        less.next = right.next;
        return left.next;
    }
}
