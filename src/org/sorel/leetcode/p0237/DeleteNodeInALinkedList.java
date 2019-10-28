package org.sorel.leetcode.p0237;

import org.sorel.leetcode.structures.ListNode;

public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
