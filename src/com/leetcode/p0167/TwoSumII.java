package com.leetcode.p0167;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1, sum = 0;
        while (l < r) {
            sum = numbers[l] + numbers[r];
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }
        return null;
    }
}
