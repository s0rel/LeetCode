package com.leetcode.p0129;

import com.leetcode.structures.TreeNode;

public class SumRootToLeafNumbers_I {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        if (node.right == null && node.left == null) {
            return sum * 10 + node.val;
        }
        return sum(node.left, sum * 10 + node.val) + sum(node.right, sum * 10 + node.val);
    }
}
