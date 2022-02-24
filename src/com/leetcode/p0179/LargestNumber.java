package com.leetcode.p0179;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        String[] arr = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(arr, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
        return Arrays.stream(arr).reduce((x, y) -> x.equals("0") ? y : x + y).get();
    }
}
