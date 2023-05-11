package com.russell._0746_min_cost_climbing_stairs;

/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost,
you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.
 */

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // pre-load total cost arrays (dp) with the cost to attain a given step, considering a start on 0 or 1.
        // need to pre-load ahead 1 step as well. The fact that you pay BEFORE stepping is tricky, because it means
        // the cost to reach stair i is actually the cost of the stair you were on previously. So the cost of stair i
        // is then the min of the total cost to reach 1 step previous plus the cost of that step,
        // or the same for 2 steps previous
        int[] dp0 = new int[cost.length+1];
        dp0[0] = 0;
        dp0[1] = cost[0];
        int[] dp1 = new int[cost.length+1];
        dp1[0] = 0;
        dp1[1] = 0;
        dp1[2] = cost[1];

        //
        for (int i = 2; i <= cost.length; i++)
            dp0[i] = Math.min(cost[i-1]+dp0[i-1], cost[i-2]+dp0[i-2]);

        for (int i = 3; i <= cost.length; i++)
            dp1[i] = Math.min(cost[i-1]+dp1[i-1], cost[i-2]+dp1[i-2]);

        return Math.min(dp0[cost.length], dp1[cost.length]);
    }
}
