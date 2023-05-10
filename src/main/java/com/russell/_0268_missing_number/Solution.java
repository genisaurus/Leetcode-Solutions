package com.russell._0268_missing_number;

/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range
that is missing from the array.
 */

class Solution {
    public int missingNumber(int[] nums) {
        // there is a math trick here, where the sum of all numbers 0...x == (x(x+1))/2. So first you find the largest
        // number in the nums[], x, because it's not sorted. Then you calculate the sum of 0...x, and subtract from
        // that the sum of values actually present in nums[].
        // n = Max(nums)
        // s = Sum(n)
        // return ((n*(n+1))/2) - s
        // However, that can give an integer overflow in some test cases, so the XOR solution is safer.
        // a^b^b == a two XOR ops with the same number will eliminate the number and reveal the original number.
        // XOR both the index and value. In a complete array with no missing numbers, the indices and values should
        // cancel completely. Because one is missing, what left finally is the missing number.
        int num = 0;
        for (int i = 0; i < nums.length; i++)
            num ^= i^nums[i];

        return num^nums.length; // the array will be 1 value shorter than x, so the final XOR is against the length
    }
}
