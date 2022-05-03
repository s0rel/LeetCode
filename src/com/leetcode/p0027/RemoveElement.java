package com.leetcode.p0027;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int l = 0;
        int r = 0;
        int len = nums.length;
        while (r < len) {
            if (nums[r] == val) {
                r++;
            } else {
                // 由于左边的指针每次赋值后会自增，所以最终的结果只需要返回左边的指针即可，不需要加 1
                nums[l++] = nums[r++];
            }
        }
        return l;
    }
}
