package org.sorel.leetcode.p0003;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = 0, len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int prev = 0, curr = 0; curr < len; curr++) {
            if (map.containsKey(s.charAt(curr))) {
                prev = Math.max(map.get(s.charAt(curr)), prev);
            }
            res = Math.max(curr - prev + 1, res); // 这里需要加上 1
            map.put(s.charAt(curr), curr + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstring_(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = 0, len = s.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0, j = 0; j < len; ) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                res = Math.max(j - i + 1, res); // 这里需要加上 1
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }
}
