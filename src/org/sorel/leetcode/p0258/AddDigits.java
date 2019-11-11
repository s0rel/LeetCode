package org.sorel.leetcode.p0258;

public class AddDigits {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
