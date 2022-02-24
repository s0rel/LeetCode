package com.leetcode.p0213;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length - 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        int prevMax = dp[nums.length - 2];

        dp = new int[nums.length - 1];
        dp[0] = nums[1];
        dp[1] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < nums.length; i++) { // 这一步要非常小心，很容易出错
            dp[i - 1] = Math.max(dp[i - 3] + nums[i], dp[i - 2]);
        }
        return Math.max(prevMax, dp[nums.length - 2]);
    }
}
