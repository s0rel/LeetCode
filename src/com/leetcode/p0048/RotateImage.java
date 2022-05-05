package com.leetcode.p0048;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int width = matrix[0].length;
        int l = 0;
        int r = length - 1;

        while (l < r) {
            swapArray(matrix, l, r);
            l++;
            r--;
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < width; j++) {
                swap(matrix, i, j);
            }
        }
    }

    private void swapArray(int[][] matrix, int i, int j) {
        int[] temp = matrix[i];
        matrix[i] = matrix[j];
        matrix[j] = temp;
    }

    private void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}
