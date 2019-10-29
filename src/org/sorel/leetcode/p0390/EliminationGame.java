package org.sorel.leetcode.p0390;

public class EliminationGame {
    public int lastRemaining(int n) {
        int head = 1, remain = n, step = 1;
        boolean left = true;
        while (remain > 1) {
            if (left || remain % 2 == 1) {
                head += step;
            }
            remain = remain / 2;
            left = !left;
            step *= 2;
        }
        return head;
    }
}
