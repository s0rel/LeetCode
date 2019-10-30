package org.sorel.leetcode.p0394;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        if (s == null || s.length() == 0) {
            return res.toString();
        }

        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                cnt = cnt * 10 + c - '0';
            } else if (c == '[') {
                countStack.push(cnt);
                strStack.push(res);
                res = new StringBuilder();
                cnt = 0;
            } else if (c == ']') {
                StringBuilder temp = res;
                res = strStack.pop();
                for (cnt = countStack.pop(); cnt > 0; --cnt) {
                    res.append(temp);
                }
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
