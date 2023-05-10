package com.russell._0347_top_k_frequent_elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer
in any order.
 */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // the highest freq any number can have is nums.length
        // so build an array where idx == freq and
        // val == List of nums with that freq. But freq is 1-indexed
        // so the array needs to be 1 larger (or freq could start at -1)
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            // default -1 if bucket.length == nums.length
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
            if (bucket[e.getValue()] == null) {
                bucket[e.getValue()] = new ArrayList<>();
            }
            bucket[e.getValue()].add(e.getKey());
        }

        // bucket[] will have empty indices where no nums had freq = i
        // so add nums to new list in reverse order
        List<Integer> results = new ArrayList<>();
        for (int i = bucket.length - 1; i > 0 && results.size() < k; i--) {
            if (bucket[i] != null) {
                results.addAll(bucket[i]);
            }
        }
        // results could be oversized if the last indices of bucket contained
        // more than k nums. Streams to covert List<Integer> to int[] is slow but whatever
        return results.subList(0,k).stream().mapToInt(i->i).toArray();
    }
    /*
    public int[] topKFrequent(int[] nums, int k) {
        // This is a lot simpler when you can use Java streams for the entire thing!
        // Unfortunately, these aren't performant enough for leetcode's time restrictions.
        //Build map of {number : frequency}
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums)
            map.put(n, map.getOrDefault(n, 0)+1);

        // Sort map entries by value (frequency), then add the keys to a list
        List<Integer> keys = map.entrySet().stream()
                            .sorted(Map.Entry.comparingByValue())
                            .map(Map.Entry::getKey)
                            .collect(Collectors.toList());

        // list is in ascending order, so return k elements from back
        int[] results = new int[k];
        for(int i = 0; i < k; i++)
            results[i] = keys.get(keys.size()-1-i);
        return results;
    }
    */
}
