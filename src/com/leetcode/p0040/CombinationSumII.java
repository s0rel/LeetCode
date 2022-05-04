package com.leetcode.p0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtracking(int[] candidates, int target, int idx, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
        } else if (target > 0) {
            for (int i = idx; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    return;
                }
                // 避免使用重复项
                if ((i > idx && candidates[i] == candidates[i - 1])) {
                    continue;
                }
                curr.add(candidates[i]);
                backtracking(candidates, target - candidates[i], i + 1, curr, res); // 这里传的是 i + 1
                curr.remove(curr.size() - 1);
            }
        }
    }
}
