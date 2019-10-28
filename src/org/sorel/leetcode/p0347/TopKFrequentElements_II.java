package org.sorel.leetcode.p0347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements_II {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : frequencies.keySet()) {
            int frequency = frequencies.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && res.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - res.size())) {
                res.addAll(buckets[i]);
            } else {
                res.addAll(buckets[i].subList(0, k - res.size()));
            }
        }
        return res;
    }
}
