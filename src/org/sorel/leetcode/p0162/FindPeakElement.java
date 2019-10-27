package org.sorel.leetcode.p0162;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int len = nums.length;
        int l = 0, r = len - 1;
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return (l == len - 1 || nums[l] > nums[l + 1]) ? l : r;
    }
}
