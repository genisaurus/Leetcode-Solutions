package com.russell._0125_valid_palindrome;

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters
and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
 */

class Solution {
    public boolean isPalindrome(String s) {
        // basic palindrome check but the input needs to be sanitized first
        StringBuilder letters = new StringBuilder();
        for (char c : s.toLowerCase().toCharArray())
            if (Character.isLetterOrDigit(c))
                letters.append(c);
        s = letters.toString();
        for (int i = 0; i < s.length()/2; i++)
            if (s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        return true;
    }
}
