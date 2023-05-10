package com.russell._0410_split_array_largest_sum;

/*
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of
any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.
 */

class Solution {
    public int splitArray(int[] nums, int k) {
        // binary search looking for the max possible value of subarrays.
        // the left side is the single largest number (the smallest largest subarray if k=1)
        // the right side is the sum of all numbers in nums[] (the smallest largest subarray if k=nums.length)
        // searching the mid should give a valid smallest-largest subarray for k, but each mid needs to be checked
        // Find left=max(nums) and right=sum(nums)
        int left = 0, right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            int mid = (left+right)/2;
            if (isValid(nums, k, mid))
                right = mid;
            else
                left = mid+1;
        }
        return right;
    }

    // checks if a given array can be split into k subarrays where the max sum == mid
    public boolean isValid(int[] nums, int k, int maxSum) {
        int curSum = 0;
        int subArrs = 0;
        for (int num : nums) {
            if (curSum + num > maxSum) {
                curSum = 0;
                subArrs++;
            }
            curSum += num;
        }
        return subArrs < k;
    }
}
