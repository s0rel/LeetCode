package org.sorel.leetcode.p0129;

import org.sorel.leetcode.structures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumRootToLeafNumbers_II {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<String> nodePath = new ArrayDeque<>();
        nodeStack.push(root);
        nodePath.push("" + root.val);
        int res = 0;
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            String currentPath = nodePath.pop();
            if (node.right != null) {
                nodeStack.push(node.right);
                nodePath.push(currentPath + ("" + node.right.val));
            }
            if (node.left != null) {
                nodeStack.push(node.left);
                nodePath.push(currentPath + ("" + node.left.val));
            }
            if (node.left == null && node.right == null) {
                res = res + Integer.parseInt(currentPath);
            }
        }
        return res;
    }
}
