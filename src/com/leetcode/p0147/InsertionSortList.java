package com.leetcode.p0147;

import com.leetcode.structures.ListNode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = head, prev = dummy, next = null;
        while (curr != null) {
            next = curr.next;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }
            curr.next = prev.next;
            prev.next = curr;
            prev = dummy;
            curr = next;
        }
        return dummy.next;
    }
}
