package com.leetcode.p0390;

public class EliminationGame {
    public int lastRemaining(int n) {
        if (n == 0) {
            return 0;
        }

        int head = 1, step = 1;
        boolean isLeft = true, isEven = ((n & 1) == 0);
        while (n != 1) {
            if (isLeft || !isEven) {
                head += step;
            }
            isLeft = !isLeft;
            n >>= 1;
            step <<= 1;
            isEven = ((n & 1) == 0);
        }
        return head;
    }
}
