package com.leetcode.p0119;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--) {
                int temp = res.get(j - 1) + res.get(j);
                res.set(j, temp);
            }
            res.add(1);
        }
        return res;
    }
}
