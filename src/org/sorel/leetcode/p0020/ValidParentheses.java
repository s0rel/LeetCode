package org.sorel.leetcode.p0020;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.poll();
                    } else {
                        return false;
                    }
                }

                if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.poll();
                    } else {
                        return false;
                    }
                }

                if (c == '}') {
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.poll();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
