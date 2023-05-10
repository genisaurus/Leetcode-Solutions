package com.russell._0557_reverse_words_in_a_string_III;

/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving
whitespace and initial word order.
 */

class Solution {
    public String reverseWords(String s) {
        // grab each word by using indexOf(" ", start), reverse it. Use a char[] to minimize String creation
        // could also just do s.split(" ") and iterate over the resulting String[], but this is technically more
        // efficient.
        char[] arr = s.toCharArray();
        int lastStart = 0;
        int nextIdxSpace = s.indexOf(" ");
        while (nextIdxSpace != -1) {
            reverse(arr, lastStart, nextIdxSpace - 1);
            lastStart = nextIdxSpace + 1;
            nextIdxSpace = s.indexOf(" ", nextIdxSpace+1);
        }
        // get the last word
        reverse(arr, lastStart, s.length()-1);

        return new String(arr);
    }

    void reverse(char[] s, int pA, int pB) {
        while (pA < pB) {
            char temp = s[pA];
            s[pA] = s[pB];
            s[pB] = temp;
            pA++;
            pB--;
        }
    }
}
