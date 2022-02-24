package com.leetcode.p0297;

import com.leetcode.structures.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    public String serialize(TreeNode root) {
        return serial(new StringBuilder(), root).toString();
    }

    private StringBuilder serial(StringBuilder str, TreeNode root) {
        if (root == null) {
            return str.append("#");
        }

        str.append(root.val).append(",");
        serial(str, root.left).append(",");
        serial(str, root.right);
        return str;
    }

    public TreeNode deserialize(String data) {
        return deserial(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    private TreeNode deserial(Queue<String> queue) {
        String val = queue.poll();
        if ("#".equals(val)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserial(queue);
        root.right = deserial(queue);
        return root;
    }
}
