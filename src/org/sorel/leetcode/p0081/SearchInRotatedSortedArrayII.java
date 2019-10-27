package org.sorel.leetcode.p0081;

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return true;
            }
            if (nums[m] > nums[l]) {
                if (target < nums[m] && target >= nums[l]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else if (nums[m] < nums[l]) {
                if (target > nums[m] && target < nums[l]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            } else {
                l++;
            }
        }
        return false;
    }
}
