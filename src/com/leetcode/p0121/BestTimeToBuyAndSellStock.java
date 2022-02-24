package com.leetcode.p0121;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = prices[0], res = 0;
        for (int price : prices) {
            if (price - min > res) {
                res = price - min;
            }
            if (price < min) {
                min = price;
            }
        }
        return res;
    }
}
