package org.sorel.leetcode.p0085;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int col = matrix[0].length;
        int[] h = new int[col + 1];
        h[col] = 0;
        int res = 0;
        for (char[] chars : matrix) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < col + 1; i++) {
                if (i < col) {
                    if (chars[i] == '1') {
                        h[i] += 1;
                    } else {
                        h[i] = 0;
                    }
                }
                if (stack.isEmpty() || h[stack.peek()] <= h[i])
                    stack.push(i);
                else {
                    while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
                        int top = stack.pop();
                        int area = h[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                        if (area > res)
                            res = area;
                    }
                    stack.push(i);
                }
            }
        }
        return res;
    }
}
