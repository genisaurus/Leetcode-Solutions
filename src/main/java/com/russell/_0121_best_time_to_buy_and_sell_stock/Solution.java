package com.russell._0121_best_time_to_buy_and_sell_stock;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in
the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

class Solution {
    public int maxProfit(int[] prices) {
        // helped by not needing to track what days to buy and sell on. So just track the current lowest price,
        // and compare each subsequent day's price-lowest to see if it generates the best profit.
        int minPrice = prices[0], best = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
                continue;
            }
            if (price - minPrice > best)
                best = price - minPrice;
        }
        return best;

    }
}
