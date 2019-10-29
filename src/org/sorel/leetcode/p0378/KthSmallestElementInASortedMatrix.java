package org.sorel.leetcode.p0378;

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int l = matrix[0][0], r = matrix[matrix.length - 1][matrix[0].length - 1] + 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            int cnt = 0, j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > m) {
                    j--;
                }
                cnt += (j + 1);
            }
            if (cnt < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
