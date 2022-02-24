package com.leetcode.p0278;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int l = 1, r = n, m = 0;
        while (l < r) {
            m = l + (r - l) / 2;
            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    // 这个方法没什么用，只是为了不让编译器报错
    private boolean isBadVersion(int left) {
        return false;
    }
}
