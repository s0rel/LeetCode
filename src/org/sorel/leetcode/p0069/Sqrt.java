package org.sorel.leetcode.p0069;

public class Sqrt {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int l = 1, r = x, m = 0, sqrt = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            sqrt = x / m;
            if (sqrt > m) {
                l = m + 1;
            } else if (sqrt < m) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return r;
    }
}
