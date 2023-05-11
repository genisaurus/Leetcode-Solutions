package com.russell._1768_merge_strings_alternately;

/*
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
starting with word1. If a string is longer than the other, append the additional letters onto the end of the
merged string.

Return the merged string.
 */

class Solution {
    public String mergeAlternately(String word1, String word2) {
        // appending alternate chars is easy, that's just appending in order on a loop. Checking if i < length
        // and testing the loop on the || of both lengths guarantees additional letters of the longer word are
        // appended to the end.
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < word1.length() || i < word2.length(); ++i) {
            if (i < word1.length())
                res.append(word1.charAt(i));
            if (i < word2.length())
                res.append(word2.charAt(i));
        }
        return res.toString();
    }
}
