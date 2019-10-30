package org.sorel.leetcode.p0389;

public class FindTheDifference_I {
    public char findTheDifference(String s, String t) {
        int[] letters = new int[26];
        for (char c : t.toCharArray()) {
            letters[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            letters[c - 'a']--;
        }

        char res = 'a';
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != 0) {
                res = (char) ('a' + i);
                break;
            }
        }
        return res;
    }
}
