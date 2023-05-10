package com.russell._0409_longest_palindrome;

/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome
that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 */

class Solution {
    public int longestPalindrome(String s) {
        // I couldn't remember the ranges of ASCII lowercase and uppercase letters, so just an array of all possible
        // ASCII values. So there'd be a problem if this string contained unicode values
        // anyway, every 2 matching letters can be used to build a palindrome, plus a single letter if one character
        // appears an odd number of times.
        int[] chars = new int[255];
        int pLen = 0;
        for (char c : s.toCharArray()) {
            chars[c]++;
            if (chars[c] % 2 == 0) {
                pLen += 2;
            }
        }
        return (s.length() - pLen != 0) ? pLen+1 : pLen;
    }
}
