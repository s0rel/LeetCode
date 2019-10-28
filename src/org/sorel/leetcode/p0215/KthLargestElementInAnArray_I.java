package org.sorel.leetcode.p0215;

public class KthLargestElementInAnArray_I {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, r = nums.length - 1, idx = 0;
        while (l < r) {
            idx = partition(nums, l, r);
            if (idx == k) {
                break;
            } else if (idx < k) {
                l = idx + 1;
            } else {
                r = idx - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int l, int r) {
        int i = l, j = r + 1;
        while (true) {
            while (nums[++i] < nums[l] && i < r) ;
            while (nums[--j] > nums[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
