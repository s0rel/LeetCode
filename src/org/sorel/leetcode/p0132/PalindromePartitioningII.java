package org.sorel.leetcode.p0132;

public class PalindromePartitioningII {
    public int minCut(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len + 1][len + 1];
        int[] min = new int[len];
        for (int i = 0; i < len; ++i) {
            min[i] = i;
            for (int j = 0; j <= i; ++j) {
                if (s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    min[i] = j == 0 ? 0 : Math.min(min[i], min[j - 1] + 1);
                }
            }
        }
        return min[len - 1];
    }
}
