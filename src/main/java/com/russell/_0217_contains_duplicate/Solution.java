package com.russell._0217_contains_duplicate;

import java.util.HashSet;
import java.util.Set;

/*
Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.
 */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // just use a set to track seen numbers.
        Set<Integer> s = new HashSet<>();
        for (int num : nums)
            if (!s.add(num))
                return true;
        return false;
    }
}
