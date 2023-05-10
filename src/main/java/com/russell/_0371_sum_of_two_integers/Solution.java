package com.russell._0371_sum_of_two_integers;

/*
Given two integers a and b, return the sum of the two integers without using the operators + and -.
 */

class Solution {
    public int getSum(int a, int b) {
        // iterating a half-adder. Low level stuff makes you feel like a wizard.
        int xor = a^b;
        int carry = (a&b);
        while(carry != 0) {
            int shiftedCarry = carry << 1;
            carry = xor & shiftedCarry;
            xor ^= shiftedCarry;
        }
        return xor;
    }
}
