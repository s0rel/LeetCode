package com.leetcode.p0006;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        StringBuilder[] arr = new StringBuilder[numRows];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuilder();
        }

        int len = s.length();
        for (int i = 0; i < len; ) {
            // 竖直向下操作
            for (int j = 0; j < numRows && i < len; j++) {
                arr[j].append(charArray[i]);
                i++;
            }

            // 沿对角线向上操作
            for (int j = numRows - 2; j > 0 && i < len; j--) {
                arr[j].append(charArray[i]);
                i++;
            }
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder temp : arr) {
            res.append(temp);
        }
        return res.toString();
    }
}
