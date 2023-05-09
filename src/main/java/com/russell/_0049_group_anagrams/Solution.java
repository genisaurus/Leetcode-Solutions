package com.russell._0049_group_anagrams;

import java.util.*;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using
all the original letters exactly once.
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // add strings to map where the key is the sorted order of characters and the value is a list of all words
        // containing the same sorted chars. e.g.   "aet" : [tea, eat, ate]
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cArr = s.toCharArray();
            Arrays.sort(cArr);
            String ordered = new String(cArr);
            if (!map.containsKey(ordered))
                map.put(ordered, new ArrayList<String>());
            map.get(ordered).add(s);
        }
        // then build a List of the Lists to return
        List<List<String>> results = new ArrayList<>();
        for (List<String> list : map.values())
            results.add(list);
        return results;
    }
}
