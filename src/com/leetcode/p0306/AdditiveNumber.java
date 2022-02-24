package com.leetcode.p0306;

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }

        int len = num.length();
        for (int i = 1; i < len; i++) {
            if (i > 1 && num.charAt(0) == '0') {
                break;
            }
            for (int j = i + 1; j < len; j++) {
                int first = 0, second = i, third = j;
                if (num.charAt(second) == '0' && third > second + 1) {
                    break;
                }
                while (third < len) {
                    long result = (Long.parseLong(num.substring(first, second)) +
                            Long.parseLong(num.substring(second, third)));
                    if (num.substring(third).startsWith(Long.toString(result))) {
                        first = second;
                        second = third;
                        third += Long.toString(result).length();
                    } else {
                        break;
                    }
                }
                if (third == len) {
                    return true;
                }
            }
        }
        return false;
    }
}
