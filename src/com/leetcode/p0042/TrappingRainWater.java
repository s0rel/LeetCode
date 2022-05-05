package com.leetcode.p0042;

public class TrappingRainWater {
    public int trap(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        int maxL = 0;
        int maxR = 0;

        while (l < r) {
            if (height[l] <= height[r]) {
                if (height[l] > maxL) {
                    maxL = height[l];
                } else {
                    res += (maxL - height[l]);
                }
                l++;
            } else {
                if (height[r] > maxR) {
                    maxR = height[r];
                } else {
                    res += (maxR - height[r]);
                }
                r--;
            }
        }
        return res;
    }
}
