package com.leetcode.p0005;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String res = "";
        int max = 0;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                boolean flag = s.charAt(i) == s.charAt(j);
                // dp[i][j] 表示 s.substring(i, j + 1) 是不是回文
                dp[i][j] = j - i > 2 ? flag && dp[i + 1][j - 1] : flag;

                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
