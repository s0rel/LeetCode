package com.leetcode.p0392;

public class IsSubsequence_I {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.trim().length() == 0) {
            return true;
        }

        int sLen = s.length(), tLen = t.length();
        int idx = 0;
        for (int i = 0; i < tLen; i++) {
            if (t.charAt(i) == s.charAt(idx)) {
                idx++;
                if (idx == sLen) {
                    break;
                }
            }
        }
        return idx == sLen;
    }
}
