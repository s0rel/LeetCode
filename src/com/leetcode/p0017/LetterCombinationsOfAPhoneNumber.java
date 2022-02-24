package com.leetcode.p0017;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        res.add(""); // 这一步很重要
        String[] mappings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int len = digits.length();
        for (int i = 0; i < len; i++) {
            res = combination(mappings[digits.charAt(i) - '0'], res);
        }
        return res;
    }

    private List<String> combination(String digit, List<String> list) {
        List<String> res = new ArrayList<>();
        int len = digit.length();
        for (int i = 0; i < len; i++) {
            for (String s : list) {
                res.add(s + digit.charAt(i));
            }
        }
        return res;
    }
}
