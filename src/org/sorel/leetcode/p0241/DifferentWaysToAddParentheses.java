package org.sorel.leetcode.p0241;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        int len = input.length();
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);

            // 每次遇到 ‘+’、'-' 和 ‘*’ 就进行递归调用
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                res.add(l + r);
                                break;
                            case '-':
                                res.add(l - r);
                                break;
                            case '*':
                                res.add(l * r);
                                break;
                        }
                    }
                }
            }
        }

        // c没有运算符，只有一个数字的情况
        if (res.isEmpty()) {
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}
