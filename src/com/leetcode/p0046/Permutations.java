package com.leetcode.p0046;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), nums);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> curr, int[] nums) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
        } else {
            for (int num : nums) {
                if (curr.contains(num)) {
                    continue;
                }
                curr.add(num);
                backtracking(res, curr, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
