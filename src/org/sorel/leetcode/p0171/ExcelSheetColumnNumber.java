package org.sorel.leetcode.p0171;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int res = 0, len = s.length();
        for (int i = len - 1, j = 0; i >= 0; i--, j++) {
            res += Math.pow(26, j) * (s.charAt(i) - 'A' + 1);
        }
        return res;
    }
}
