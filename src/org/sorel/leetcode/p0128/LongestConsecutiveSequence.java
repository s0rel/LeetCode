package org.sorel.leetcode.p0128;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int prev = 0, next = 0;
        for (int num : nums) {
            if (set.remove(num)) {
                prev = num - 1;
                next = num + 1;
                while (set.remove(prev)) {
                    prev--;
                }
                while (set.remove(next)) {
                    next++;
                }
                res = Math.max(res, next - prev - 1);
            }
        }
        return res;
    }
}
