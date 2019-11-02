package org.sorel.leetcode.p0312;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        int n = 1;
        for (int num : nums) {
            if (num > 0) {
                arr[n++] = num;
            }
        }
        arr[0] = arr[n++] = 1;

        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int l = 0; l < n - k; ++l) {
                int r = l + k;
                for (int i = l + 1; i < r; ++i) {
                    dp[l][r] = Math.max(dp[l][r], arr[l] * arr[i] * arr[r] + dp[l][i] + dp[i][r]);
                }
            }
        return dp[0][n - 1];
    }
}
