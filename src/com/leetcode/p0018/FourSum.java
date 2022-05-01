package com.leetcode.p0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);
    }

    private List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (k == 2) {
            int l = start;
            int r = len - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    List<Integer> path = new ArrayList<>();
                    path.add(nums[l]);
                    path.add(nums[r]);
                    res.add(path);
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        } else {
            for (int i = start; i < len - (k - 1); i++) {
                if (i == start || nums[i] != nums[i - 1]) {
                    List<List<Integer>> temp = kSum(nums, i + 1, k - 1, target - nums[i]);
                    for (List<Integer> t : temp) {
                        t.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
            }
        }
        return res;
    }
}
