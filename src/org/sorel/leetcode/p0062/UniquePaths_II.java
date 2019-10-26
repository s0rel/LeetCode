package org.sorel.leetcode.p0062;

public class UniquePaths_II {
    public int uniquePaths(int m, int n) {
        int S = m + n - 2, D = m - 1;
        long res = 1;
        for (int i = 1; i <= D; i++) {
            res = res * (S - D + i) / i;
        }
        return (int) res;
    }
}
