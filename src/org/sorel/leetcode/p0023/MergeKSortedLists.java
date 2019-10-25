package org.sorel.leetcode.p0023;

import org.sorel.leetcode.structures.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        ListNode head = new ListNode(-1), curr = head;
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            if (curr.next != null) {
                queue.add(curr.next);
            }
        }
        return head.next;
    }
}
