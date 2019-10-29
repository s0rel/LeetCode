package org.sorel.leetcode.p0372;

public class SuperPow {
    public int superPow(int a, int[] b) {
        if (a % 1337 == 0) {
            return 0;
        }

        int p = 0;
        for (int i : b) {
            p = (p * 10 + i) % 1140;
        }
        if (p == 0) {
            p += 1440;
        }
        return power(a, p, 1337);
    }

    private int power(int a, int n, int mod) {
        a %= mod;
        int res = 1;
        while (n != 0) {
            if ((n & 1) != 0) {
                res = res * a % mod;
            }
            a = a * a % mod;
            n >>= 1;
        }
        return res;
    }
}
