package com.leetcode.p0033;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int minIndex = findMinIndex(nums);
        if (target == nums[minIndex]) {
            return minIndex;
        }

        int len = nums.length;
        int l = (target <= nums[len - 1]) ? minIndex : 0;
        int r = (target > nums[len - 1]) ? minIndex : len - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    private int findMinIndex(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        // l 不能等于 r，因为这将导致死循环
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
