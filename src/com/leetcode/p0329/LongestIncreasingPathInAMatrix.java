package com.leetcode.p0329;

public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, dp);
                res = Math.max(res, len);
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int m, int n, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int res = 1;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] direction : directions) {
            int x = i + direction[0], y = j + direction[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            res = Math.max(res, dfs(matrix, x, y, m, n, dp) + 1);
        }
        dp[i][j] = res;
        return res;
    }
}
