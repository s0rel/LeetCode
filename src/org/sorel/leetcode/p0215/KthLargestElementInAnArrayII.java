package org.sorel.leetcode.p0215;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArrayII {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>(); // 小顶堆
        for (int num : nums) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}
