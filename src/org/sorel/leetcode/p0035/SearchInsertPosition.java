package org.sorel.leetcode.p0035;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0] > target) { // 不能取等号
            return 0;
        }
        if (nums[nums.length - 1] < target) { // 不能取等号
            return nums.length;
        }

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }
}
