package org.sorel.leetcode.p0242;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] letters = new int[26];
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            letters[c - 'a']--;
        }

        for (int cnt : letters) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }
}
