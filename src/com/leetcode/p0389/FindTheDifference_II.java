package com.leetcode.p0389;

public class FindTheDifference_II {
    public char findTheDifference(String s, String t) {
        int sCount = 0, tCount = 0;
        for (char c : s.toCharArray()) {
            sCount += c;
        }
        for (char c : t.toCharArray()) {
            tCount += c;
        }
        return (char) (tCount - sCount);
    }
}
