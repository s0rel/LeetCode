package org.sorel.leetcode.p0047;

import java.util.*;

public class Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        return new ArrayList<>(backtracking(res, nums, 0));
    }

    private Set<List<Integer>> backtracking(Set<List<Integer>> res, int[] nums, int pos) {
        if (pos == nums.length) {
            return res;
        }

        Set<List<Integer>> newResult = new HashSet<>();
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
