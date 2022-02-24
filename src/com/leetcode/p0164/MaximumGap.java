package com.leetcode.p0164;

import java.util.Arrays;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int max = nums[0], min = nums[0], len = nums.length;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int gap = (int) Math.ceil((double) (max - min) / (len - 1));
        int[] bucketsMIN = new int[len - 1];
        int[] bucketsMAX = new int[len - 1];
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);

        for (int num : nums) {
            if (num == min || num == max) {
                continue;
            }
            int idx = (num - min) / gap;
            bucketsMIN[idx] = Math.min(num, bucketsMIN[idx]);
            bucketsMAX[idx] = Math.max(num, bucketsMAX[idx]);
        }

        int res = Integer.MIN_VALUE;
        int prev = min;
        for (int i = 0; i < len - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE) {
                continue;
            }
            res = Math.max(res, bucketsMIN[i] - prev);
            prev = bucketsMAX[i];
        }
        res = Math.max(res, max - prev);
        return res;
    }
}
