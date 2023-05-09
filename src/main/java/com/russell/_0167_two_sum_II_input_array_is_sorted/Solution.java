package com.russell._0167_two_sum_II_input_array_is_sorted;

/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that
they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2]
where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // two pointers, at the beginning and end. If the sum is greater than the target, decrement end pointer.
        // if the sum is less than the target, increment beginning pointer. Solution is guaranteed
        int pA = 0;
        int pB = numbers.length-1;

        while (pA < pB) {
            if (numbers[pA] + numbers[pB] > target)
                pB--;
            else if (numbers[pA] + numbers[pB] < target)
                pA++;
            else
                break;
        }
        // Answer should be 1-indexed
        return new int[] {pA+1, pB+1};
    }
}
