package com.russell._0053_maximum_subarray;

/*
Given an integer array nums, find the subarray with the largest sum, and return its sum.
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int overallMax = nums[0];
        // variable width sliding window, similar to 121. Best Time to Buy and Sell Stocks
        // the currentMax sliding window either adds nums[i] or is replaced with nums[i] if the latter is greater
        // the overallMax result is the largest of all currentMax windows
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            overallMax = Math.max(currentMax, overallMax);
        }
        return overallMax;
    }
}
