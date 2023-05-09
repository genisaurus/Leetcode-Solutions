package com.russell._0122_best_time_to_buy_and_sell_stock_II;

/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.
 */

class Solution {
    public int maxProfit(int[] prices) {
        // feels unoptimized at t=O(n) and s=O(n)
        // build a boolean array indicating whether prices will trend upwards the FOLLOWING day. Then we can use that
        // info to make buy/sell decisions
        if (prices.length <= 1)
            return 0;
        boolean[] trendingUp = new boolean[prices.length-1];
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i+1] > prices[i])
                trendingUp[i] = true;
            else
                trendingUp[i] = false;
        }
        int totalProfit = 0, lastBuy = prices[0];
        boolean lastTrend = trendingUp[0];

        for (int i = 0; i < trendingUp.length; i++) {
            // if the tomorrow is trending the same as today, skip today...
            if (lastTrend == trendingUp[i]) {
                // unless this is the last day for which we have data, and the price tomorrow is higher. Then we want
                // to sell at tomorrow's price
                if (i == trendingUp.length-1 && trendingUp[i])
                    totalProfit += prices[i+1] - lastBuy;
                // otherwise skip
                continue;
            }
            // if the price is going up tomorrow, buy today
            if (trendingUp[i]) {
                lastBuy = prices[i];
            } else {
                // if the price is going down tomorrow, sell and reset last buy price
                totalProfit += prices[i] - lastBuy;
                lastBuy = 0;
            }
            lastTrend = trendingUp[i];
            // sanity check to sell if tomorrow is the last day AND has an increase in price.
            if (i == trendingUp.length-1 && trendingUp[i])
                totalProfit += prices[i+1] - lastBuy;
        }
        return totalProfit;
    }
}
