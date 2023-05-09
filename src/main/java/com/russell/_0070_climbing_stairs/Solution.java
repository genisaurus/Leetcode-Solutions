package com.russell._0070_climbing_stairs;

/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

class Solution {
    public int climbStairs(int n) {
        // memoized fib sequence. TBH I just recognized the pattern from the examples, and it turned out to be
        // correct. But the interpretation goes:
        // 1 stair has 1 possible step combo,   (1)
        // 2 stairs has 2 possible step combos, (1,1), (2)
        // 3 stairs has 3 possible step combos, (1,1,1), (2,1) | (1,2)
        // 4 stairs has 5 possible step combos, (1,1,1,1), (2,1,1), (1,2,1) | (1,1,2), (2,2)
        // because you can always take the same combos that brought you to the previous step, and then add 1 more step
        // (n-1), or you could take the combos that would bring you to second-previous step, adn then add a double step
        // (n-2). The total number of combos is the sum of the 2.
        if (n == 1)
            return 1;

        int[] memo = new int[n+2];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
        for (int i = 3; i <= n+1; i++)
            memo[i] = memo[i-2] + memo[i-1];

        return memo[n+1];
    }
}
