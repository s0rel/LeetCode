package org.sorel.leetcode.p0238;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, 1);

        int left = 1, right = 1;
        for (int i = 1; i < len; i++) {
            left *= nums[i - 1];
            res[i] *= left;
        }
        for (int i = len - 2; i >= 0; i--) {
            right *= nums[i + 1];
            res[i] *= right;
        }
        return res;
    }
}
