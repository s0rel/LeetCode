package org.sorel.leetcode.p0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtracking(int[] candidates, int target, int idx, List<Integer> curr, List<List<Integer>> res) {
        if (target > 0) {
            for (int i = idx; i < candidates.length; i++) {
                // 避免使用重复项
                if (candidates[i] > target || (i > idx && candidates[i - 1] == candidates[i])) {
                    continue; // 这里只能是 continue，而不能是 break
                }
                curr.add(candidates[i]);
                backtracking(candidates, target - candidates[i], i + 1, curr, res); // 这里传的是 i + 1
                curr.remove(curr.size() - 1);
            }
        } else if (target == 0) {
            res.add(new ArrayList<>(curr));
        }
    }
}
