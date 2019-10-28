package org.sorel.leetcode.p0233;

public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }

        int q = n, x = 1, res = 0;
        do {
            int digit = q % 10;
            q /= 10;
            res += q * x;
            if (digit == 1) {
                res += (n % x + 1);
            }
            if (digit > 1) {
                res += x;
            }
            x *= 10;
        } while (q > 0);
        return res;
    }
}
