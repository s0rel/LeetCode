package com.leetcode.p0003;

import java.util.HashSet;
import java.util.Set;

/**
 * 滑动窗口
 */
public class LongestSubstringWithoutRepeatingCharacters_II {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0, j = 0; j < s.length(); ) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                res = Math.max(j - i + 1, res);
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }
}
