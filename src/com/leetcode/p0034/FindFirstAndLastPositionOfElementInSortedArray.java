package com.leetcode.p0034;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }

        result[0] = findStartPosition(nums, target);
        result[1] = findEndPosition(nums, target);
        return result;
    }

    public int findStartPosition(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int start = -1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                start = m;
                r = m - 1;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return start;
    }

    public int findEndPosition(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int end = -1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                end = m;
                l = m + 1;
            } else if (target > nums[m])
                l = m + 1;
            else
                r = m - 1;
        }

        return end;
    }
}
