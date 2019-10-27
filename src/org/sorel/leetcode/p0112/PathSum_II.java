package org.sorel.leetcode.p0112;

import org.sorel.leetcode.structures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PathSum_II {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.left == null && curr.right == null) {
                if (curr.val == sum) {
                    return true;
                }
            }
            if (curr.right != null) {
                curr.right.val = curr.val + curr.right.val;
                stack.push(curr.right);
            }
            if (curr.left != null) {
                curr.left.val = curr.val + curr.left.val;
                stack.push(curr.left);
            }
        }
        return false;
    }
}
