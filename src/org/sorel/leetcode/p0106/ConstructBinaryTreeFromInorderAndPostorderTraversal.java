package org.sorel.leetcode.p0106;

import org.sorel.leetcode.structures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        stack.push(root);
        int i = postorder.length - 2, j = inorder.length - 1;
        while (i >= 0) {
            TreeNode curr = stack.peek();
            if (curr.val != inorder[j]) {
                TreeNode right = new TreeNode(postorder[i]);
                curr.right = right;
                stack.push(right);
                i--;
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[j]) {
                    curr = stack.pop();
                    j--;
                }
                TreeNode left = new TreeNode(postorder[i]);
                curr.left = left;
                stack.push(left);
                i--;
            }
        }
        return root;
    }
}
