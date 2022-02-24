package com.leetcode.p0228;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 1) {
            res.add(nums[0] + "");
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (i + 1 < nums.length && (nums[i + 1] - nums[i]) == 1) {
                i++;
            }
            if (num != nums[i]) {
                res.add(num + "->" + nums[i]);
            } else {
                res.add(num + "");
            }
        }
        return res;
    }
}
