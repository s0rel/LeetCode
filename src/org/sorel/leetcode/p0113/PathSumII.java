package org.sorel.leetcode.p0113;

import org.sorel.leetcode.structures.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        pathSum(root, sum, curr, res);
        return res;
    }

    private void pathSum(TreeNode root, int sum, List<Integer> curr, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        curr.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new LinkedList<>(curr));
            curr.remove(curr.size() - 1);
            return;
        } else {
            pathSum(root.left, sum - root.val, curr, res);
            pathSum(root.right, sum - root.val, curr, res);
        }
        curr.remove(curr.size() - 1);
    }
}
