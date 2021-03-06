package org.sorel.leetcode.p0011;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int res = 0, l = 0, r = height.length - 1;
        while (l < r) {
            res = Math.max(Math.min(height[l], height[r]) * (r - l), res);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
