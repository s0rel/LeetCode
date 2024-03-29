package com.leetcode.p0022;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtracking(res, "", 0, 0, n);
        return res;
    }

    private void backtracking(List<String> res, String s, int open, int close, int n) {
        if (s.length() == 2 * n) {
            res.add(s);
            return;
        }

        if (open < n) {
            backtracking(res, s + "(", open + 1, close, n);
        }
        if (close < open) {
            backtracking(res, s + ")", open, close + 1, n);
        }
    }
}
