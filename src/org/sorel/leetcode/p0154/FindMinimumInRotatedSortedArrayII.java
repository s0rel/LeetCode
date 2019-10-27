package org.sorel.leetcode.p0154;

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int l = 0, m = 0, r = nums.length - 1;
        while (l < r) {
            m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else if (nums[m] < nums[r]) {
                r = m;
            } else {
                r--;
            }
        }
        return nums[l];
    }
}
