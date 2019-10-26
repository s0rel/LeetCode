package org.sorel.leetcode.p0075;

public class SortColors {
    public void sortColors(int[] nums) {
        int red = 0, blue = nums.length - 1, idx = 0;
        while (idx <= blue) {
            if (nums[idx] == 0) {
                nums[idx] = nums[red];
                nums[red] = 0;
                red++;
            }
            if (nums[idx] == 2) {
                nums[idx] = nums[blue];
                nums[blue] = 2;
                blue--;
                idx--;
            }
            idx++;
        }
    }
}
