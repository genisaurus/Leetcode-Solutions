package com.russell._0242_valid_anagram;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using
all the original letters exactly once.
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        // saving on space by using a char[26], and taking advantage of ASCII value patterns.
        // count how many occurrences of each letter there are in s, and subtract the occurrences of each letter in t.
        // if the array is subsequently all 0's, they're anagrams.
        if (s.length() != t.length())
            return false;

        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)-'a']++;
            map[t.charAt(i)-'a']--;
        }
        for (int i : map)
            if (i != 0)
                return false;
        return true;

        /*
        // you could do it with 2 maps too, but that's not as cool
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)-1);
        }
        for (Integer i : map.values())
            if (i != 0)
                return false;
        return true;
        */
    }
}
