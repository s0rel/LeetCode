package com.leetcode.p0077;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        backtracking(nums, k, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtracking(int[] nums, int k, int idx, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
        } else if (curr.size() < k) {
            for (int i = idx; i < nums.length; i++) {
                curr.add(nums[i]);
                backtracking(nums, k, i + 1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
