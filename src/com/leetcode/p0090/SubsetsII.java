package com.leetcode.p0090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtracking(int[] nums, int idx, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));
        for (int i = idx; i < nums.length; i++) {
            // 避免使用重复项
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            backtracking(nums, i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
