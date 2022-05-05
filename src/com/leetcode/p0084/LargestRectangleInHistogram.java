package com.leetcode.p0084;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int res = 0;
        int[] stack = new int[len + 1];
        int is = -1;
        for (int i = 0; i <= len; i++) {
            int height = (i == len) ? 0 : heights[i];
            while (is != -1 && height < heights[stack[is]]) {
                int hh = heights[stack[is--]];
                int width = (is == -1) ? i : i  - stack[is] - 1;
                res = Math.max(res, hh * width);
            }
            stack[++is] = i;
        }
        return res;
    }
}
