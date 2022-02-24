package com.leetcode.p0033;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int num;
            if ((nums[m] < nums[0]) == (target < nums[0])) {
                num = nums[m];
            } else {
                num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            if (num < target) {
                l = m + 1;
            } else if (num > target) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
