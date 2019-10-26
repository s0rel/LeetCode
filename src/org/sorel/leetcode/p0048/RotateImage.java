package org.sorel.leetcode.p0048;

public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix[0] == null || matrix[0].length == 0) {
            return;
        }

        int l = 0, r = matrix.length - 1;
        while (l < r) {
            int[] temp = matrix[l];
            matrix[l] = matrix[r];
            matrix[r] = temp;
            l++;
            r--;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
