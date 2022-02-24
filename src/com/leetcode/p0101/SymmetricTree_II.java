package com.leetcode.p0101;

import com.leetcode.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree_II {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return true;
        }

        queue.offer(root.left);
        queue.offer(root.right);
        while (queue.size() > 1) {
            TreeNode left = queue.poll(), right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null ^ right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
