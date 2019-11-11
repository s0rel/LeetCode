package org.sorel.leetcode.p0230;

import org.sorel.leetcode.structures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        int cnt = 0;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.pop();
                if (++cnt == k) {
                    return node.val;
                }
                curr = node.right;
            }
        }
        return Integer.MIN_VALUE;
    }
}
