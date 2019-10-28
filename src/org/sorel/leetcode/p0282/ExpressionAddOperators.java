package org.sorel.leetcode.p0282;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num.length() == 0) {
            return res;
        }

        char[] path = new char[num.length() * 2 - 1];
        char[] digits = num.toCharArray();
        long n = 0;
        for (int i = 0; i < digits.length; i++) {
            n = n * 10 + digits[i] - '0';
            path[i] = digits[i];
            dfs(res, path, i + 1, 0, n, digits, i + 1, target);
            if (n == 0) {
                break;
            }
        }
        return res;
    }

    private void dfs(List<String> res, char[] path, int len, long left, long curr, char[] digits, int pos, int target) {
        if (pos == digits.length) {
            if (left + curr == target) {
                res.add(new String(path, 0, len));
            }
            return;
        }

        long n = 0;
        int j = len + 1;
        for (int i = pos; i < digits.length; i++) {
            n = n * 10 + digits[i] - '0';
            path[j++] = digits[i];
            path[len] = '+';
            dfs(res, path, j, left + curr, n, digits, i + 1, target);
            path[len] = '-';
            dfs(res, path, j, left + curr, -n, digits, i + 1, target);
            path[len] = '*';
            dfs(res, path, j, left, curr * n, digits, i + 1, target);
            if (digits[pos] == '0') {
                break;
            }
        }
    }
}
