package com.leetcode.p0104;

import com.leetcode.structures.TreeNode;

public class MaximumDepthOfBinaryTree_I {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
