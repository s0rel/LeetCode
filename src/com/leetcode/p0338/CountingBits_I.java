package com.leetcode.p0338;

public class CountingBits_I {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; ++i) {
            res[i] = popcount(i);
        }
        return res;
    }

    private int popcount(int x) {
        int cnt;
        for (cnt = 0; x != 0; ++cnt) {
            x &= x - 1;
        }
        return cnt;
    }
}
