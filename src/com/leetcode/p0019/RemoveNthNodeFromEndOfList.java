package com.leetcode.p0019;

import com.leetcode.structures.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode r = head;
        ListNode l = head;
        while (r != null && n > 0) {
            r = r.next;
            n--;
        }

        if (r == null) {
            return head.next;
        }

        while (r.next != null) {
            r = r.next;
            l = l.next;
        }
        l.next = l.next.next;
        return head;
    }
}
