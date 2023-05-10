package com.russell._0516_longest_palindromic_subsequence;

import java.util.Arrays;

/*
Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without
changing the order of the remaining elements.
 */

class Solution {
    public int longestPalindromeSubseq(String s) {
        // 2D dynamic programming problem, see helper method for breakdown
        int[][] table = new int[s.length()][s.length()];
        for (int[] row : table)
            Arrays.fill(row, -1);

        // we don't need to do the DP solution for any palindromic sequences at the borders, those are quick
        // to compute
        int start = 0;
        int end = s.length()-1;
        int pre = 0;
        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
            pre+=2;
        }

        return pre + helper(s, start, end, table);
    }

    // [i][j] represent the start and end index of a given substring
    // base cases:
    // if i<j, return 0: empty substring
    // if i==j, return 1: a single character is a palindrome with length of 1
    // if the substring has already been solved, return that
    // recursion:
    // if s[i] == s[j], [i][j] = 2 + recursive call moving i and j closer
    // else, [i][j] = Max of substring after moving only 1 pointer
    public int helper(String s, int i, int j, int[][] table) {
        if (i > j)
            return 0;
        if (i == j)
            return 1;

        if (table[i][j] != -1)
            return table[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            table[i][j] = 2 + helper(s, i+1, j-1, table);
        } else {
            table[i][j] = Math.max(helper(s, i+1, j, table), helper(s, i, j-1, table));
        }

        return table[i][j];
    }

}
