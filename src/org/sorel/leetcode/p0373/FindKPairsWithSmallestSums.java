package org.sorel.leetcode.p0373;

import java.util.*;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0) {
            return res;
        }

        int len1 = nums1.length, len2 = nums2.length;
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> (nums1[o[0]] + nums2[o[1]])));
        for (int i = 0; i < len1; i++) {
            queue.offer(new int[]{i, 0});
        }
        while (!queue.isEmpty() && k > 0) {
            int[] pair = queue.poll();
            if (pair[1] + 1 < len2) {
                queue.offer(new int[]{pair[0], pair[1] + 1});
            }
            res.add(Arrays.asList(nums1[pair[0]], nums2[pair[1]]));
            k--;
        }
        return res;
    }
}
