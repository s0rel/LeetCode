package com.leetcode.p0004;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        return (findKth(nums1, nums2, (m + n + 1) / 2) + findKth(nums1, nums2, (m + n + 2) / 2)) / 2.0;
    }

    /**
     * 找出两个有序数组中的第 k 个元素
     */
    private int findKth(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;

        if (m == 0) {
            return nums2[k - 1];
        }
        if (n == 0) {
            return nums1[k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[0], nums2[0]);
        }

        int i = Math.min(m, k / 2);
        int j = Math.min(n, k / 2);
        if (nums1[i - 1] > nums2[j - 1]) {
            // 前 j 个元素已确定，所以只需要取出 k - j 个元素
            return findKth(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
        } else {
            return findKth(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
        }
    }
}
