package org.sorel.leetcode.p0337;

import org.sorel.leetcode.structures.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return getMaxValue(root, map);
    }

    private int getMaxValue(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }

        int val = 0;
        if (root.left != null) {
            val += getMaxValue(root.left.left, map) + getMaxValue(root.left.right, map);
        }
        if (root.right != null) {
            val += getMaxValue(root.right.left, map) + getMaxValue(root.right.right, map);
        }
        int max = Math.max(root.val + val, getMaxValue(root.left, map) + getMaxValue(root.right, map));
        map.put(root, max);
        return max;
    }
}
