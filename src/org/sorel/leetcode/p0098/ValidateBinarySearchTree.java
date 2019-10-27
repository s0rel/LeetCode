package org.sorel.leetcode.p0098;

import org.sorel.leetcode.structures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && root.val <= prev.val) {
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }
}
