package org.sorel.leetcode.p0368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] += 1;
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int maxIndex = 0;
        for (int i = 1; i < len; i++) {
            maxIndex = dp[i] > dp[maxIndex] ? i : maxIndex;
        }

        int max = nums[maxIndex];
        for (int i = maxIndex; i >= 0; i--) {
            if (max % nums[i] == 0 && dp[maxIndex] - dp[i] <= 1) {
                res.add(nums[i]);
                max = nums[i];
                maxIndex = i;
            }
        }
        Collections.sort(res);
        return res;
    }
}
