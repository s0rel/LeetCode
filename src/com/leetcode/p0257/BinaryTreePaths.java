package com.leetcode.p0257;

import com.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> strQueue = new LinkedList<>();
        if (root == null) {
            return res;
        }

        nodeQueue.offer(root);
        strQueue.offer("");
        while (!nodeQueue.isEmpty()) {
            TreeNode curNode = nodeQueue.poll();
            String curStr = strQueue.poll();

            if (curNode.left == null && curNode.right == null) {
                res.add(curStr + curNode.val);
            }
            if (curNode.left != null) {
                nodeQueue.offer(curNode.left);
                strQueue.offer(curStr + curNode.val + "->");
            }
            if (curNode.right != null) {
                nodeQueue.offer(curNode.right);
                strQueue.offer(curStr + curNode.val + "->");
            }
        }
        return res;
    }
}
