package com.leetcode.p0204;

public class CountPrimes {
    public int countPrimes(int n) {
        int res = 0;
        boolean[] prime = new boolean[n];
        for (int i = 0; i < n; i++) {
            prime[i] = true;
        }
        for (int i = 2; i < n; i++) {
            if (!prime[i]) {
                continue;
            }
            res++;
            for (int j = 2; j * i < n; j++) { // 小于 n 的质数
                prime[i * j] = false;
            }
        }
        return res;
    }
}
