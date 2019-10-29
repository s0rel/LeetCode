package org.sorel.leetcode.p0389;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int len = t.length();
        char c = t.charAt(len - 1);
        for (int i = 0; i < len - 1; i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
}
