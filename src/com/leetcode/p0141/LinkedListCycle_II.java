package com.leetcode.p0141;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle_II {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
