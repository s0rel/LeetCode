package org.sorel.leetcode.p0059;

public class SpiralMatrix_II {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, top = 0, right = n - 1, down = n - 1;
        int cnt = 1;
        while (left <= right) {
            for (int j = left; j <= right; j++) {
                res[top][j] = cnt++;
            }
            top++;

            for (int i = top; i <= down; i++) {
                res[i][right] = cnt++;
            }
            right--;

            for (int j = right; j >= left; j--) {
                res[down][j] = cnt++;
            }
            down--;
            
            for (int i = down; i >= top; i--) {
                res[i][left] = cnt++;
            }
            left++;
        }
        return res;
    }
}
