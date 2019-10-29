package org.sorel.leetcode.p0377;

import java.util.Arrays;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] sum = new int[target + 1];
        sum[0] = 1;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < len && nums[j] <= i; j++) {
                sum[i] += sum[i - nums[j]];
            }
        }
        return sum[target];
    }
}
