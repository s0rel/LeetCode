package com.leetcode.p0007;

public class ReverseInteger {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            // 不需要区分 x 的正负
            res = res * 10 + x % 10;
            x /= 10;
        }

        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) res;
        }
    }
}
