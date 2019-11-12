package org.sorel.leetcode.p0150;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int a, b;
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : tokens) {
            switch (s) {
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a + b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        return stack.pop();
    }
}
