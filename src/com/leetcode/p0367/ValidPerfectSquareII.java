package com.leetcode.p0367;

public class ValidPerfectSquareII {
    public boolean isPerfectSquare(int num) {
        int subnum = 1;
        while (num > 0) {
            num -= subnum;
            subnum += 2;
        }
        return num == 0;
    }
}
