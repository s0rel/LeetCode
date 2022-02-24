package com.leetcode.p0365;

public class WaterAndJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == z || y == z || x + y == z) {
            return true;
        }
        return z % GCD(x, y) == 0;
    }

    private int GCD(int i, int j) {
        while (j != 0) {
            int temp = j;
            j = i % j;
            i = temp;
        }
        return i;
    }
}
