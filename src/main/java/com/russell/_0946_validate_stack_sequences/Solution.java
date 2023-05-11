package com.russell._0946_validate_stack_sequences;

import java.util.Stack;

/*
Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result
of a sequence of push and pop operations on an initially empty stack, or false otherwise.
 */

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // I used a stack to validate the stack. If that's verboten, there's an array solution below
        // here we push elements onto the stack one by one, but if the element we push is the next element in the
        // popped array, we pop an element and look at the next item in popped[]
        // if the stack is empty at the end, the sequence is valid.
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int n : pushed) {
            stack.push(n);
            while(!stack.empty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();

        /*
        // uses pushed[] as a stack, incrementing i for every value pushed and then decrementing it for
        // every element popped (uses the same check as above).
        public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;

        for(int val : pushed){
            pushed[i++] = val; // using pushed as the stack.
            while(i > 0 && pushed[i - 1] == popped[j]){ // pushed[i - 1] values equal to popped[j];
                i--; // decrement i
                j++; // increment j
            }
        }
        return i == 0; //
        */
    }
}
