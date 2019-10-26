package org.sorel.leetcode.p0046;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        return backtracking(res, nums, 0);
    }

    private List<List<Integer>> backtracking(List<List<Integer>> res, int[] nums, int pos) {
        if (pos == nums.length) {
            return res;
        }

        List<List<Integer>> newResult = new ArrayList<>();
        for (List<Integer> eachList : res) {
            for (int i = 0; i <= eachList.size(); i++) { // 这里要取 "="
                List<Integer> newList = new ArrayList<>(eachList);
                newList.add(i, nums[pos]);
                newResult.add(newList);
            }
        }
        res = newResult;
        return backtracking(res, nums, pos + 1);
    }
}
