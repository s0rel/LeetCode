package com.leetcode.p0003;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters_I {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = 0;
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < len; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            res = Math.max(j - i + 1, res);
            map.put(s.charAt(j), j + 1);
        }
        return res;
    }
}
