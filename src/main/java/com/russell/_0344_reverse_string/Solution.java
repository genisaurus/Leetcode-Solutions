package com.russell._0344_reverse_string;

/*
Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.
 */

class Solution {
    public void reverseString(char[] s) {
        // basic converging 2-pointer swap
        int pA = 0;
        int pB = s.length-1;
        while (pA < pB) {
            char temp = s[pA];
            s[pA] = s[pB];
            s[pB] = temp;
            pA++;
            pB--;
        }
    }
}
