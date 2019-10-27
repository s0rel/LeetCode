package org.sorel.leetcode.p0100;

import org.sorel.leetcode.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree_II {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode f = queue.poll();
            TreeNode s = queue.poll();
            if (f == null && s == null) {
                continue;
            } else if (f == null || s == null || f.val != s.val) {
                return false;
            }
            queue.offer(f.left);
            queue.offer(s.left);
            queue.offer(f.right);
            queue.offer(s.right);
        }
        return true;
    }
}
