package com.leetcode.p0131;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>>[] res = new List[len + 1];
        res[0] = new ArrayList<>();
        res[0].add(new ArrayList<>());

        boolean[][] pair = new boolean[len][len];
        for (int i = 0; i < s.length(); i++) {
            res[i + 1] = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 1 || pair[j + 1][i - 1])) {
                    pair[j][i] = true;
                    String str = s.substring(j, i + 1);
                    for (List<String> list : res[j]) {
                        List<String> l = new ArrayList<>(list);
                        l.add(str);
                        res[i + 1].add(l);
                    }
                }
            }
        }
        return res[len];
    }
}
