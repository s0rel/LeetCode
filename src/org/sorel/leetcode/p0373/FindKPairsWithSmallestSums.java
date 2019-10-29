package org.sorel.leetcode.p0373;

import java.util.*;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<List<Integer>> queue = new PriorityQueue<>((a, b) -> a.get(0) + a.get(1) - b.get(0) - b.get(1));
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }
        for (int i = 0; i < nums1.length && i < k; i++) {
            queue.offer(Arrays.asList(nums1[i], nums2[0], 0));
        }
        while (k-- > 0 && !queue.isEmpty()) {
            List<Integer> curr = queue.poll();
            res.add(Arrays.asList(curr.get(0), curr.get(1)));
            if (curr.get(2) == nums2.length - 1) {
                continue;
            }
            queue.offer(Arrays.asList(curr.get(0), nums2[curr.get(2) + 1], curr.get(2) + 1));
        }
        return res;
    }
}
