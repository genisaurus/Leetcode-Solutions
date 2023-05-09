package com.russell._0035_search_insert_position;

/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not,
return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        // basic binary search, but using [left + ((right-left) / 2)] instead of [(left+right) / 2]
        // to avoid integer overflow in some test cases (the midpoint between left and right is left + half the
        // distance between left and right)
        // searching for a point where the target == nums[mid] for an easy insertion. Otherwise, the insertion
        // point will be at the index of whichever is greater, nums[left] or nums[left+1]:
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left < right) {
            mid = left + ((right-left) / 2);

            if (target < nums[mid])
                right = mid-1;
            else if (target > nums[mid])
                left = mid+1;
            else return mid;
        }
        return nums[left] < target ? left+1: left;
    }
}
