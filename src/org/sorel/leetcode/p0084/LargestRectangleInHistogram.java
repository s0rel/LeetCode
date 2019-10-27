package org.sorel.leetcode.p0084;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = i == len ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int curHeight = heights[stack.pop()];
                int prevIndex = stack.isEmpty() ? -1 : stack.peek();
                int area = curHeight * (i - prevIndex - 1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
