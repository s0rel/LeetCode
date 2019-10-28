package org.sorel.leetcode.p0279;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PerfectSquaresI {
    public int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] flag = new boolean[n + 1];
        queue.add(n);
        flag[n] = true;
        int level = 0, len = 0;
        while (!queue.isEmpty()) {
            len = queue.size();
            level++;
            while (len-- > 0) {
                int curr = queue.poll();
                for (int s : squares) {
                    int next = curr - s;
                    if (next < 0) {
                        break;
                    } else if (next == 0) {
                        return level;
                    }

                    if (flag[next]) {
                        continue;
                    }
                    flag[next] = true;
                    queue.add(next);
                }
            }
        }
        return level;
    }

    // 生成小于 n 的平方数序列
    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1, diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }
}
