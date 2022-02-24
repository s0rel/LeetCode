package com.leetcode.p0088;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m - 1, idx2 = n - 1, idx = m + n - 1;
        while (idx1 >= 0 || idx2 >= 0) {
            if (idx1 < 0) {
                nums1[idx--] = nums2[idx2--];
            } else if (idx2 < 0) {
                nums1[idx--] = nums1[idx1--];
            } else if (nums1[idx1] >= nums2[idx2]) {
                nums1[idx--] = nums1[idx1--];
            } else {
                nums1[idx--] = nums2[idx2--];
            }
        }
    }
}
