package com.leetcode.p0386;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }

        for (int i = 1; i < 10; ++i) {
            dfs(i, n, res);
        }
        return res;
    }

    private void dfs(int curr, int n, List<Integer> res) {
        if (curr <= n) {
            res.add(curr);
            for (int i = 0; i < 10; ++i) {
                if (10 * curr + i <= n) {
                    dfs(10 * curr + i, n, res);
                }
            }
        }
    }
}
