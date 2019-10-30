package org.sorel.leetcode.p0395;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k > s.length()) {
            return 0;
        }
        return count(s.toCharArray(), k, 0, s.length() - 1);
    }

    private int count(char[] arr, int k, int l, int r) {
        if (r - l + 1 < k) {
            return 0;
        }

        int[] freq = new int[26];
        for (int i = l; i <= r; i++) {
            ++freq[arr[i] - 'a'];
        }
        while (r - l + 1 >= k && freq[arr[l] - 'a'] < k) {
            ++l;
        }
        while (r - l + 1 >= k && freq[arr[r] - 'a'] < k) {
            --r;
        }

        for (int i = l; i <= r; i++) {
            if (freq[arr[i] - 'a'] < k) {
                return Math.max(count(arr, k, l, i - 1), count(arr, k, i + 1, r));
            }
        }
        return r - l + 1;
    }
}
