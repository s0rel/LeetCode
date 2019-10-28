package org.sorel.leetcode.p0227;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculatorII {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
                if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '+') {
                    stack.push(num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int res = 0;
        for (int val : stack) {
            res += val;
        }
        return res;
    }
}
