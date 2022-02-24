package com.leetcode.p0042;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int res = 0;
        int l = 0, r = height.length - 1, maxL = 0, maxR = 0;
        while (l <= r) {
            if (height[l] <= height[r]) {
                if (height[l] >= maxL) {
                    maxL = height[l];
                } else {
                    res += (maxL - height[l]);
                }
                l++;
            } else {
                if (height[r] >= maxR) {
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
