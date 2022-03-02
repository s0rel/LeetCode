package com.leetcode.p0005;

/**
 * 动态规划
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int len = s.length();
        String res = "";
        boolean[][] dp = new boolean[len][len];
        int max = 0;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                boolean flag = s.charAt(i) == s.charAt(j);
                dp[i][j] = j - i > 2 ? dp[i + 1][j - 1] && flag : flag;

                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
