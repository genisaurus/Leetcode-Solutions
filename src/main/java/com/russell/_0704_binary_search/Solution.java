package com.russell._0704_binary_search;

/*
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search
target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.
 */

class Solution {
    public int search(int[] nums, int target) {
        // basic binary search, done here without overflow protection in calculating mid
        // (would be   left+((right-left)/2))   otherwise)
        if (nums.length == 1)
            if (nums[0] == target)
                return 0;

        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left < right) {
            mid = (left+right)/2;
            if (nums[mid] < target)
                left = mid+1;
            else
                right = mid;

            if (nums[left] == target)
                return left;
            if (nums[mid] == target)
                return mid;

        }
        return -1;
    }
}
