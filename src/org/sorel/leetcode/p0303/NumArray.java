package org.sorel.leetcode.p0303;

public class NumArray {
    private int[] sums;

    // 注意边界条件
    public NumArray(int[] nums) {
        sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sums[i] = nums[i];
            } else {
                sums[i] = sums[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sums[j];
        }
        return sums[j] - sums[i - 1];
    }
}
