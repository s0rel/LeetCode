package com.leetcode.p0020;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (isNotPaired(stack, c, ')', '(')) {
                    return false;
                }
                if (isNotPaired(stack, c, ']', '[')) {
                    return false;
                }
                if (isNotPaired(stack, c, '}', '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isNotPaired(Deque<Character> stack, char c, char right, char left) {
        if (c == right) {
            if (!stack.isEmpty() && stack.peek() == left) {
                stack.poll();
            } else {
                return true;
            }
        }
        return false;
    }
}
