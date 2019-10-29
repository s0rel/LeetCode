package org.sorel.leetcode.p0392;

public class IsSubsequence_II {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.trim().length() == 0) {
            return true;
        }

        int idx = -1;
        for (char c : s.toCharArray()) {
            idx = t.indexOf(c, idx + 1);
            if (idx == -1) {
                return false;
            }
        }
        return true;
    }
}
