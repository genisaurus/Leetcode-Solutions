package com.russell._0509_fibonacci_number;

/*
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is
the sum of the two preceding ones, starting from 0 and 1. That is,
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).
 */

class Solution {
    public int fib(int n) {
        // simple memoized fib
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++)
            memo[i] = memo[i-2] + memo[i-1];

        return memo[n];
    }
}
