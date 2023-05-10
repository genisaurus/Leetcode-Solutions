package com.russell._0201_bitwise_and_of_numbers_range;

/*
Given two integers left and right that represent the range [left, right], return the bitwise AND of all
numbers in this range, inclusive.
 */

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        //  The trick here is that : Bitwise-AND of any two numbers will always
        //  produce a number less than or equal to the smaller number. Once you
        //  hit some power of 2 between left and right, the answer becomes 0

        /*
        // t=O(n) which is unoptimized
        while (right>left) {
            right &= right-1;
        }
        return right;
        */

        // Avoids timeout by starting with right and decrementing.
        // Closer to t=O(logn)? At least not strictly O(n)
        if (left == right)
            return left;

        long nextPow2 = (int) Math.ceil((Math.log(left)/Math.log(2)));

        // if the left number is a power of 2, bitwise & to the next one
        if (left == Math.pow(2,nextPow2))
            nextPow2 = (long)Math.pow(2, nextPow2+1);
        else
            nextPow2 = (long)Math.pow(2, nextPow2);

        if (right >= nextPow2)
            return 0;
        else
            for (int i = right; i >= left; i--)
                right &= i;
        return right;

    }
}
