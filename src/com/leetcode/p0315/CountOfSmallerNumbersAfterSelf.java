package com.leetcode.p0315;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        int[][] aux = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{nums[i], i};
        }
        int[] count = new int[n];
        sort(arr, count, 0, n - 1, aux);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(count[i]);
        }
        return res;
    }

    private void sort(int[][] arr, int[] count, int l, int h, int[][] aux) {
        if (l >= h) {
            return;
        }

        int m = l + (h - l) / 2;
        sort(arr, count, l, m, aux);
        sort(arr, count, m + 1, h, aux);
        if (h + 1 - l >= 0) {
            System.arraycopy(arr, l, aux, l, h + 1 - l);
        }
        int i = l, j = m + 1;
        for (int k = l; k <= h; k++) {
            if (i == m + 1) {
                arr[k] = aux[j++];
            } else if (j == h + 1 || aux[i][0] <= aux[j][0]) {
                count[aux[i][1]] += j - (m + 1);
                arr[k] = aux[i++];
            } else {
                arr[k] = aux[j++];
            }
        }
    }
}
