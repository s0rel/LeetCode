package com.leetcode.p0039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtracking(int[] candidates, int target, int idx, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            // 这里需要新建一个 ArrayList 对象
            res.add(new ArrayList<>(curr));
        } else if (target > 0) {
            for (int i = idx; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    return;
                }
                curr.add(candidates[i]);
                // 由于数组内的元素可以重复使用，所以这里传的是 i
                backtracking(candidates, target - candidates[i], i, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
