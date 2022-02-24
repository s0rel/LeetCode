package com.leetcode.p0304;

public class NumMatrix {
    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }

        int row = matrix.length, col = matrix[0].length;
        dp = new int[row][col + 1];
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                dp[x][y + 1] = dp[x][y] + matrix[x][y];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int row = row1; row <= row2; row++) {
            sum += dp[row][col2 + 1] - dp[row][col1];
        }
        return sum;
    }
}
