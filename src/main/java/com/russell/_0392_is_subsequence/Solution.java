package com.russell._0392_is_subsequence;

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of
the characters without disturbing the relative positions of the remaining characters.
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */

class Solution {
    public boolean isSubsequence(String s, String t) {
        // iterate over s, and find the next index of s.charAt(i) in t. Start each search for the next character of s
        // at the index of the last letter found. Not a subsequence if you can't find the next letter of s in t, or
        // if the starting index for the next search exceeds the length of t
        int lastIndex = -1;
        for(int i = 0; i < s.length(); i++) {
            lastIndex = t.indexOf( s.charAt(i), lastIndex );
            if (lastIndex != -1)
                lastIndex++;
            else
                return false;

            if (i < (s.length()-1) && lastIndex >= (t.length()))
                return false;
        }
        return true;
    }
}
