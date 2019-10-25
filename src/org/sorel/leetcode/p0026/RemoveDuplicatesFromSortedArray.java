package org.sorel.leetcode.p0026;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int prev = 0, curr = 0, len = nums.length;
        while (curr < len) {
            if (nums[prev] == nums[curr]) {
                curr++;
            } else {
                nums[++prev] = nums[curr++];
            }
        }
        return prev + 1;
    }
}
