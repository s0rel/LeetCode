package com.leetcode.p0345;

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String vowels = "aeiouAEIOU";
        char[] words = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !vowels.contains(words[l] + "")) {
                l++;
            }
            while (l < r && !vowels.contains(words[r] + "")) {
                r--;
            }

            char temp = words[l];
            words[l] = words[r];
            words[r] = temp;
            l++;
            r--;
        }
        return new String(words);
    }
}
