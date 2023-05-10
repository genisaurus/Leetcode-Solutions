package com.russell._0350_intersection_of_two_arrays_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must
appear as many times as it shows in both arrays and you may return the result in any order.
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // the restriction that we the returned int[] should contain union numbers in the same quantity means
        // it's easier to start with the shorter number, since no quantity in the returned int[] can exceed what's
        // found in there
        int[] shorter = nums1.length < nums2.length ? nums1 : nums2;
        int[] longer = nums1.length >= nums2.length ? nums1 : nums2;

        // number : count
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : shorter) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        // now build the answer by iterating over the longer nums[], and adding any values that were in the shorter
        // nums[] to a List. Remember to decrement the count remaining.
        List<Integer> matches = new ArrayList<>();
        for (int i : longer) {
            if (map.containsKey(i) && map.get(i) > 0) {
                matches.add(i);
                map.put(i, map.get(i)-1);
            }
        }
        // manually convert List<Integer> to int[] for speed
        int[] arr = new int[matches.size()];
        for (int i = 0; i < arr.length; i++)
            arr[i] = matches.get(i);
        return arr;
        // streams are slower, if more readable:
        // return matches.stream().mapToInt(i->i).toArray();
    }
}
