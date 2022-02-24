package com.leetcode.p0027;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int idx = 0, len = nums.length;
        while (idx < len) {
            if (nums[idx] == val) {
                nums[idx] = nums[len - 1];
                len--;
            } else {
                idx++;
            }
        }
        return len;
    }
}
