package org.sorel.leetcode.p0008;

public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }

        String s = str.trim();
        int pos = 0, res = 0, len = s.length();
        boolean flag = (s.charAt(0) == '-'); // 负数标记
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            pos++;
        }

        for (; pos < len; pos++) {
            if (s.charAt(pos) < '0' || s.charAt(pos) > '9') {
                break;
            } else {
                int digit = s.charAt(pos) - '0';
                if (!flag && res > (Integer.MAX_VALUE - digit) / 10) {
                    return Integer.MAX_VALUE;
                } else if (flag && res < (Integer.MIN_VALUE + digit) / 10) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + (flag ? -digit : digit);
            }
        }
        return res;
    }
}
