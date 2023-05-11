package com.russell._2218_maximum_value_of_k_coins_from_piles;

import java.util.List;

/*
There are n piles of coins on a table. Each pile consists of a positive number of coins of assorted denominations.

In one move, you can choose any coin on top of any pile, remove it, and add it to your wallet.

Given a list piles, where piles[i] is a list of integers denoting the composition of the ith pile from top to bottom,
and a positive integer k, return the maximum total value of coins you can have in your wallet if you choose exactly k
coins optimally.
 */

class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        // picks x piles, picks are 1-based counting
        int[][] memo = new int[k+1][piles.size()];
        for (int i = 0; i <= k; i++)
            for (int j = 0; j < piles.size(); j++)
                memo[i][j] = -1;

        return helper(piles, k, memo, 0);
    }

    int helper(List<List<Integer>> piles, int k, int[][] memo, int i) {
        if (k <= 0 || i >= piles.size())
            return 0;

        if (memo[k][i] != -1)
            return memo[k][i];

        int coinCount = piles.get(i).size();
        int maxPickCount = Math.min(k, coinCount);

        // case: Don't pick from this pile
        int result = helper(piles, k, memo, i+1);

        // case: Pick from this pile
        int pickSum = 0;
        for (int j = 0; j < maxPickCount; j++) {
            pickSum += piles.get(i).get(j);
            // after picking current value, test if we moved to the next pile
            int temp = helper(piles, k-j-1, memo, i+1);
            result = Math.max(result, pickSum+temp);
        }
        memo[k][i] = result;
        /* Visualize memo
        System.out.println("Memo:");
        for (int m = 0; m < memo.length; m++) {
            for (int n = 0; n < memo[m].length; n++) {
                System.out.print(memo[m][n] + ", \t");
            }
            System.out.print("\n");
        }
        */
        return result;
    }
}
