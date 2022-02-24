package com.leetcode.p0067;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int flag = 0, m = a.length() - 1, n = b.length() - 1, p = 0, q = 0, sum = 0;
        while (flag == 1 || m >= 0 || n >= 0) {
            p = m >= 0 ? a.charAt(m--) - '0' : 0;
            q = n >= 0 ? b.charAt(n--) - '0' : 0;
            sum = p + q + flag;
            res.append(sum % 2);
            flag = (sum) / 2;
        }
        return res.reverse().toString();
    }
}
