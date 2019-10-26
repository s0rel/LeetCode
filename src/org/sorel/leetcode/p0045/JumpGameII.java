package org.sorel.leetcode.p0045;

public class JumpGameII {
    public int jump(int[] nums) {
        int res = 0, last = 0, curr = 0, len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            curr = Math.max(curr, nums[i] + i);
            if (i == last) {
                last = curr;
                res++;
                if (curr == len - 1) {
                    break;
                }
            }
        }
        return res;
    }
}
