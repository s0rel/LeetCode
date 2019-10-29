package org.sorel.leetcode.p0395;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] letters = new char[26];
        for (int i = 0; i < s.length(); i += 1) {
            letters[s.charAt(i) - 'a'] += 1;
        }
        boolean flag = true;
        for (char c : letters) {
            if (c < k && c > 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return s.length();
        }

        int res = 0;
        int start = 0, curr = 0;
        while (curr < s.length()) {
            if (letters[s.charAt(curr) - 'a'] < k) {
                res = Math.max(res, longestSubstring(s.substring(start, curr), k));
                start = curr + 1;
            }
            curr++;
        }
        res = Math.max(res, longestSubstring(s.substring(start), k));
        return res;
    }
}
