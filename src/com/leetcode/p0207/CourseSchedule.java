package com.leetcode.p0207;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int ready = prerequisite[0];
            int pre = prerequisite[1];
            if (matrix[pre][ready] == 0) {
                indegree[ready]++;
            }
            matrix[pre][ready] = 1;
        }

        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            cnt++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0)
                        queue.offer(i);
                }
            }
        }
        return cnt == numCourses;
    }
}
