package com.leetcode.p0085;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;
        int[] heights = new int[n];
        int max = 0;
        for (char[] row : matrix) {
            for (int i = 0; i < n; i++) {
                if (row[i] == '1') {
                    heights[i] += 1;
                } else {
                    heights[i] = 0;
                }
            }
            max = Math.max(max, maxArea(heights));
        }
        return max;
    }

    public int maxArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = heights.length;
        int max = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int index = stack.pop();
                int leftBound = -1;
                if (!stack.isEmpty()) {
                    leftBound = stack.peek();
                }
                max = Math.max(max, heights[index] * (i - leftBound - 1));
            }
            stack.push(i);
        }
        return max;
    }
}
