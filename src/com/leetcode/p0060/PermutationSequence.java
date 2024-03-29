package com.leetcode.p0060;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int[] fact = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        int sum = 1;
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            fact[i] = sum;
        }

        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        k--;
        for (int i = 1; i <= n; i++) {
            int index = k / fact[n - i];
            sb.append(nums.get(index));
            nums.remove(index);
            k -= index * fact[n - i];
        }
        return sb.toString();
    }
}
