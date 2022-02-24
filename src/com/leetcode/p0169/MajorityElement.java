package com.leetcode.p0169;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int cnt = 0, res = nums[0];
        for (int num : nums) {
            res = (cnt == 0) ? num : res;
            cnt = (num == res) ? (cnt + 1) : (cnt - 1);
        }
        return res;
    }
}
