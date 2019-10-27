package org.sorel.leetcode.p0122;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // 这里要从第一天开始观察，但不能从第一天就买入
        int prev = prices[0], res = 0;
        for (int price : prices) {
            if (price > prev) {
                res += (price - prev);
            }
            prev = price;
        }
        return res;
    }
}
