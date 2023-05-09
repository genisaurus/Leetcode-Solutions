package com.russell._0189_rotate_array;

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 */

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // if k < n, we would get a - index below, and the shifting would loop around twice
        // so this takes the remainder for the second loop around
        k = k%n;
        // reverse up to n-k
        reverse(nums, 0, n-k-1);
        // reverse from k+1 to n
        reverse(nums, n-k, n-1);
        // reverse entire array
        reverse(nums, 0, n-1);

    }

    void reverse(int[] arr, int low, int high) {
        int temp = 0;
        while (low < high) {
            temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
}
