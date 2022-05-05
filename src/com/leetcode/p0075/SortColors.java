package com.leetcode.p0075;

public class SortColors {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        for (int i = l; i <= r; ) {
            if (nums[i] == 0) {
                swap(nums, i, l);
                i++;
                l++;
            } else if (nums[i] == 2) {
                swap(nums, i, r);
                r--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
