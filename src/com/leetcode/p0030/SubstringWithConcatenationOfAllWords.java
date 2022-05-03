package com.leetcode.p0030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        int num = words.length;
        int wordLen = words[0].length();

        for (int i = 0; i < s.length() - num * wordLen + 1; i++) {
            String sub = s.substring(i, i + num * wordLen);
            if (isConcat(sub, counts, wordLen)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isConcat(String sub, Map<String, Integer> counts, int wordLen) {
        Map<String, Integer> seen = new HashMap<>();
        for (int i = 0; i < sub.length(); i += wordLen) {
            String sWord = sub.substring(i, i + wordLen);
            seen.put(sWord, seen.getOrDefault(sWord, 0) + 1);
        }
        return seen.equals(counts);
    }
}
