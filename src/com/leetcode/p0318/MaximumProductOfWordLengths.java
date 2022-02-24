package com.leetcode.p0318;

public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }

        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            String word = words[i];
            value[i] = 0;
            for (int j = 0; j < word.length(); j++) {
                value[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++) {
                if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > res)) {
                    res = words[i].length() * words[j].length();
                }
            }
        return res;
    }
}
