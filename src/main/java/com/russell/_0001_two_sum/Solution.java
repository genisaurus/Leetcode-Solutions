package com.russell._0001_two_sum;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // t=O(n) | s=O(n)
        // iterate over the array, add target-num to the map as the key, the value is the index of num.
        // so for every subsequent num in the array, if it exists in the map then its corresponding operand
        // has been previously found. return [value of (target-num1), i]
        Map<Integer, Integer> answers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (answers.containsKey(nums[i]))
                return new int[] { i, answers.get(nums[i]) };
            else
                answers.put(target-nums[i], i);
        }
        /*
        // t=O(n^2) | s=O(1)
        // nested loop searching every combination of values. At least the inner loop can always start
        // after i, since x+y == y+x
        for (int i = 0; i < nums.length-1; i++)
            for(int j = i+1; j < nums.length; j++)
                if (nums[i]+nums[j] == target)
                    return new int[] {i,j};
        return new int[] {0,0};
        */
        return new int[] {0,0};
    }
}
