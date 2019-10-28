package org.sorel.leetcode.p0239;

import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int len = nums.length;
        int[] res = new int[len - k + 1];
        Queue<Integer> queue = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        res[0] = queue.peek();
        for (int i = k; i < len; i++) {
            queue.remove(nums[i - k]);
            queue.add(nums[i]);
            res[i - k + 1] = queue.peek();
        }
        return res;
    }
}
