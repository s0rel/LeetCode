package com.leetcode.p0349;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                intersect.add(num);
            }
        }

        int[] res = new int[intersect.size()];
        int cnt = 0;
        for (int num : intersect) {
            res[cnt++] = num;
        }
        return res;
    }
}
