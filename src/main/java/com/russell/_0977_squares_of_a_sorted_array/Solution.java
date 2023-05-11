package com.russell._0977_squares_of_a_sorted_array;

/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in
non-decreasing order.
 */

class Solution {
    public int[] sortedSquares(int[] nums) {
        // this can be tricky because the squares of negative numbers produce positive numbers, so a sorted array
        // will not produce an array of squares that is also sorted. However, the resultant array would be "mirrored"
        // in that the larger values will be at either end, and the lowest values in the middle.
        // 2-pointer solution, compares abs(left) vs abs(right), and inserts the highest into
        // the result array as a square, moving right to left
        int[] result = new int[nums.length];
        int i = nums.length-1;
        int right = nums.length-1;
        int left = 0;

        while (i >= 0) {
            if (Math.abs(nums[right]) > Math.abs(nums[left])) {
                result[i] = nums[right] * nums[right];
                right--;
            } else {
                result[i] = nums[left] * nums[left];
                left++;
            }
            i--;
        }

        return result;
    }
}
