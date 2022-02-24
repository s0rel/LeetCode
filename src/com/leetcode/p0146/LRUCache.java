package com.leetcode.p0146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, DLinkNode> cache;
    private DLinkNode tail = null;
    private DLinkNode head = null;
    private int capacity;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DLinkNode target = cache.get(key);
            int value = target.value;
            target.update();
            return value;
        } else return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DLinkNode target = cache.get(key);
            target.value = value;
            target.update();
        } else {
            if (capacity == 0) return;
            if (cache.size() == capacity) {
                cache.remove(head.key);
                head.removeFromHead();
            }
            DLinkNode newNode = new DLinkNode(key, value);
            newNode.append();
            cache.put(key, newNode);
        }
    }

    class DLinkNode {
        int key;
        int value;
        DLinkNode left = null;
        DLinkNode right = null;

        DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        private void removeFromHead() {
            if (tail == this) {
                head = null;
                tail = null;
            } else {
                head = this.right;
                head.left = null;
            }
        }

        private void update() {
            if (tail != this) {
                if (this != head) {
                    this.left.right = this.right;
                } else {
                    head = this.right;
                }
                this.right.left = this.left;
                this.append();
            }
        }

        private void append() {
            if (tail == null) {
                head = this;
                tail = this;
            } else {
                this.right = null;
                this.left = tail;
                tail.right = this;
                tail = this;
            }
        }
    }
}
