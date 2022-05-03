package com.leetcode.p0026;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int l = 0;
        int r = 0;
        int len = nums.length;
        while (r < len) {
            if (nums[l] == nums[r]) {
                r++;
            } else {
                // 左边的指针先自增用于存储新元素，然后右边的指针自增
                nums[++l] = nums[r++];
            }
        }
        return l + 1;
    }
}
