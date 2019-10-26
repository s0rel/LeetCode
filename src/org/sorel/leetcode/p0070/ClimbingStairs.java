package org.sorel.leetcode.p0070;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int t1 = 1, t2 = 2, sum = 0;
        for (int i = 2; i < n; i++) {
            sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
        return sum;
    }
}
