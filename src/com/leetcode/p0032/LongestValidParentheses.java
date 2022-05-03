package com.leetcode.p0032;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(i - stack.peek(), res);
                }
            }
        }
        return res;
    }
}
