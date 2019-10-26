package org.sorel.leetcode.p0049;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] arr = new int[26];
            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(arr);
            List<String> tempList = map.getOrDefault(key, new ArrayList<>());
            tempList.add(s);
            map.put(key, tempList);
        }
        return new ArrayList<>(map.values());
    }
}
