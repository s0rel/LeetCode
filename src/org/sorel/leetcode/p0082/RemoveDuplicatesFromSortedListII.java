package org.sorel.leetcode.p0082;

import org.sorel.leetcode.structures.ListNode;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, curr = head;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            if (prev.next == curr) {
                prev = prev.next;
            } else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
