package com.leetcode.p0025;

import com.leetcode.structures.ListNode;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode curr = dummy;
        dummy.next = head;

        int len = 0;
        while (curr.next != null) {
            len++;
            curr = curr.next;
        }

        while (len >= k) {
            curr = prev.next;
            for (int i = 1; i < k; i++) {
                ListNode next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = curr;
            len -= k;
        }
        return dummy.next;
    }
}
