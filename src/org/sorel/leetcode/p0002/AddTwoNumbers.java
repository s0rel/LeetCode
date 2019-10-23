package org.sorel.leetcode.p0002;

import org.sorel.leetcode.structures.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1), curr = head;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int v1 = (l1 == null) ? 0 : l1.val;
            int v2 = (l2 == null) ? 0 : l2.val;
            int sum = v1 + v2 + flag;
            flag = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }

        if (flag == 1) { // 处理最高位有进位的情况
            curr.next = new ListNode(1);
        }
        return head.next;
    }
}
