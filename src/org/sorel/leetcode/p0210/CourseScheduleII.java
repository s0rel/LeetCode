package org.sorel.leetcode.p0210;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
            return new int[]{};
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] degrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            degrees[prerequisite[0]]++;
            if (!map.containsKey(prerequisite[1])) {
                map.put(prerequisite[1], new HashSet<>());
            }
            map.get(prerequisite[1]).add(prerequisite[0]);
        }
        int count = 0, valid = 0;
        int[] res = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                count++;
                res[valid++] = i;
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (!map.containsKey(curr) || map.get(curr).size() == 0) {
                continue;
            }
            for (int child : map.get(curr)) {
                degrees[child]--;
                if (degrees[child] == 0) {
                    count++;
                    queue.offer(child);
                    res[valid++] = child;
                }
            }
        }
        return count == numCourses ? res : new int[]{};
    }
}
