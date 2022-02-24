package com.leetcode.p0331;

import java.util.ArrayDeque;
import java.util.Deque;

public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }

        Deque<String> stack = new ArrayDeque<>();
        String[] arr = preorder.split(",");
        for (String curr : arr) {
            while (curr.equals("#") && !stack.isEmpty() && stack.peek().equals(curr)) {
                stack.pop();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            stack.push(curr);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}
