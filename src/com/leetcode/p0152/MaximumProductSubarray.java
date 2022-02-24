package com.leetcode.p0152;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int prod = 1;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            prod = prod * num;
            res = Math.max(prod, res);
            if (prod == 0) {
                prod = 1;
            }
        }

        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prod = prod * nums[i];
            res = Math.max(prod, res);
            if (prod == 0) {
                prod = 1;
            }
        }
        return res;
    }
}
