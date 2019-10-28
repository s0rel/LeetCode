package org.sorel.leetcode.p0313;

import java.util.Arrays;

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] indexs = new int[primes.length];
        int[] values = new int[primes.length];
        Arrays.fill(values, 1);

        int next = 1;
        for (int i = 0; i < n; i++) {
            ugly[i] = next;
            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (values[j] == ugly[i]) {
                    values[j] = ugly[indexs[j]++] * primes[j];
                }
                next = Math.min(next, values[j]);
            }
        }
        return ugly[n - 1];
    }
}
