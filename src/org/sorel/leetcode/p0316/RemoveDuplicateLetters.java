package org.sorel.leetcode.p0316;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] letters = new int[26];
        boolean[] visited = new boolean[26];
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            letters[c - 'a']++;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : charArray) {
            int idx = c - 'a';
            letters[idx]--;
            if (visited[idx]) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && letters[stack.peek() - 'a'] != 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[idx] = true;
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}
