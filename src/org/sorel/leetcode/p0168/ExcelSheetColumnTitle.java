package org.sorel.leetcode.p0168;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if (n == 0) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        while (n > 0) {
            if (n % 26 == 0) {
                res.append('Z');
                n -= 26;
            } else {
                res.append((char) (n % 26 - 1 + 'A')); // 这里必须强转
                n -= (n % 26);
            }
            n /= 26;
        }
        return res.reverse().toString();
    }
}
