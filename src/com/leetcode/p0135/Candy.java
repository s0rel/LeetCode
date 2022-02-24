package com.leetcode.p0135;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        for (int i = len - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                dp[i - 1] = Math.max(dp[i] + 1, dp[i - 1]);
            }
        }

        return Arrays.stream(dp).sum();
    }
}
