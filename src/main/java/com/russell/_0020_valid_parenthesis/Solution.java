package com.russell._0020_valid_parenthesis;

import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 */

class Solution {
    public boolean isValid(String s) {
        // push openers to a stack, which keeps them in reverse order
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if (c == '(' || c=='[' || c=='{') {
                stack.push(c);
            } else {
                // if the string contains no openers, it's invalid
                if (stack.isEmpty())
                    return false;
                // if the current char isn't an opener to push, it must be a closer
                // pop an opener, and see if it matches the current closer. if it doesn't, it's invalid
                char p = stack.pop();
                if (p == '(' && c != ')' ||
                        p == '[' && c != ']' ||
                        p == '{' && c != '}')
                    return false;
            }
        }
        // only valid if all openers have been popped and matched to corresponding closers without returning false
        return stack.isEmpty();
    }
}
