package com.leetcode.p0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < len - 2; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int l = j + 1;
                        int r = len - 1;
                        while (l < r) {
                            int sum = nums[i] + nums[j] + nums[l] + nums[r];
                            if (sum == target) {
                                res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                                while (l + 1 < r && nums[l] == nums[l + 1]) {
                                    l++;
                                }
                                while (r - 1 > l && nums[r] == nums[r - 1]) {
                                    r--;
                                }
                                l++;
                                r--;
                            } else if (sum > target) {
                                r--;
                            } else {
                                l++;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
