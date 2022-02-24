package com.leetcode.p0378;

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length;
        int l = matrix[0][0], r = matrix[row - 1][col - 1];
        while (l < r) {
            int m = l + (r - l) / 2;
            int cnt = findNotBiggerThanMid(matrix, m, row, col);
            if (cnt < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }

    private int findNotBiggerThanMid(int[][] matrix, int mid, int row, int col) {
        int i = row - 1, j = 0;
        int cnt = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] <= mid) {
                cnt += (i + 1);
                j++;
            } else {
                i--;
            }
        }
        return cnt;
    }
}
