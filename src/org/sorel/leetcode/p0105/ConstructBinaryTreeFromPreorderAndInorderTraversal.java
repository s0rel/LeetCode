package org.sorel.leetcode.p0105;

import org.sorel.leetcode.structures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]), curr = root;
        for (int i = 1, j = 0; i < preorder.length; i++) {
            if (curr.val != inorder[j]) {
                curr.left = new TreeNode(preorder[i]);
                stack.push(curr);
                curr = curr.left;
            } else {
                j++;
                while (!stack.isEmpty() && stack.peek().val == inorder[j]) {
                    curr = stack.pop();
                    j++;
                }
                curr = curr.right = new TreeNode(preorder[i]);
            }
        }
        return root;
    }
}
