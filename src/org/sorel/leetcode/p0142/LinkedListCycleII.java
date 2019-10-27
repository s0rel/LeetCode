package org.sorel.leetcode.p0142;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head, curr = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (slow != curr) {
                    slow = slow.next;
                    curr = curr.next;
                }
                return curr;
            }
        }
        return null;
    }
}
