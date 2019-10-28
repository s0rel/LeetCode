package org.sorel.leetcode.p0295;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    private Queue<Long> small;
    private Queue<Long> large;

    public MedianFinder() {
        small = new PriorityQueue<>();
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (large.size() < small.size()) {
            large.add(-small.poll());
        }
    }

    public double findMedian() {
        return large.size() > small.size()
                ? large.peek()
                : (large.peek() - small.peek()) / 2.0;
    }
}
