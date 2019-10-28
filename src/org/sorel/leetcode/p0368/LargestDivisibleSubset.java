package org.sorel.leetcode.p0368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        int[] cnt = new int[len];
        int[] pre = new int[len];
        Arrays.sort(nums);
        int max = 0, index = -1;
        for (int i = 0; i < len; i++) {
            cnt[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + cnt[j] > cnt[i]) {
                        cnt[i] = cnt[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (cnt[i] > max) {
                max = cnt[i];
                index = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}
