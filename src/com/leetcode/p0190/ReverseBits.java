package com.leetcode.p0190;

public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int end = n & 1;
            n >>= 1;
            res <<= 1;
            res |= end;
        }
        return res;
    }
}
