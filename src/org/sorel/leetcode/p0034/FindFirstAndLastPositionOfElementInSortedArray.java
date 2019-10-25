package org.sorel.leetcode.p0034;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int l = 0, r = nums.length - 1;
        int[] res = new int[2];
        while (l < r) {
            int m = l + (r - l) / 2;
            if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        res[0] = (target == nums[l]) ? l : -1;

        r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2 + 1;
            if (target < nums[m]) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        res[1] = (target == nums[r]) ? r : -1;

        return res;
    }
}
