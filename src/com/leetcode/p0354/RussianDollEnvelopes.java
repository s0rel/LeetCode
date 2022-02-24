package com.leetcode.p0354;

import java.util.Arrays;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2) {
            return 0;
        }

        Arrays.sort(envelopes, (arr1, arr2) -> {
            if (arr1[0] == arr2[0]) {
                return arr2[1] - arr1[1];
            } else {
                return arr1[0] - arr2[0];
            }
        });
        int[] dp = new int[envelopes.length];
        int res = 0;
        for (int[] envelope : envelopes) {
            int l = 0, r = res, m = 0;
            while (l < r) {
                m = l + (r - l) / 2;
                if (dp[m] < envelope[1]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            dp[l] = envelope[1];
            if (l == res) {
                res++;
            }
        }
        return res;
    }
}
