package com.leetcode.p0332;

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        if (tickets == null || tickets.size() == 0) {
            return res;
        }

        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (!map.containsKey(ticket.get(0))) {
                map.put(ticket.get(0), new PriorityQueue<>());
            }
            map.get(ticket.get(0)).add(ticket.get(1));
        }

        String curr = "JFK";
        Deque<String> drawBack = new ArrayDeque<>();
        for (int i = 0; i < tickets.size(); i++) {
            while (!map.containsKey(curr) || map.get(curr).isEmpty()) {
                drawBack.push(curr);
                curr = res.remove(res.size() - 1);
            }
            res.add(curr);
            curr = map.get(curr).poll();
        }
        res.add(curr);
        while (!drawBack.isEmpty()) {
            res.add(drawBack.pop());
        }
        return res;
    }
}
