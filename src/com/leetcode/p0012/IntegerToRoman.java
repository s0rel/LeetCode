package com.leetcode.p0012;

public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int len = values.length;
        for (int i = 0; i < len; i++) {
            while (num >= values[i]) {
                num -= values[i];
                res.append(roman[i]);
            }
        }
        return res.toString();
    }
}
