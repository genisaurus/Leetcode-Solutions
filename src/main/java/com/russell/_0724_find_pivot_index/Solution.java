package com.russell._0724_find_pivot_index;

/*
Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum
of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This
also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.
 */

class Solution {
    public int pivotIndex(int[] nums) {
        // calculate the sum of all elements, then iterate over nums[]
        // adding to left sum and subtracting from right sum. When equal, pivot
        int pivot = -1;
        int lSum = 0;
        int rSum = 0;
        for (int i = 0; i < nums.length; i++)
            rSum += nums[i];

        for (int i = 0; i < nums.length; i++) {
            rSum -= nums[i];
            if (lSum == rSum) {
                pivot = i;
                break;
            }
            lSum += nums[i];
        }
        return pivot;
    }
}
