package com.leetcode.p0055;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int idx = 0;
        for (int reach = 0; idx < len && idx <= reach; idx++) {
            reach = Math.max(idx + nums[idx], reach);
        }
        return idx == len;
    }
}
