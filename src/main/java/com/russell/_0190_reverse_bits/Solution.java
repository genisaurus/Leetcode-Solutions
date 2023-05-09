package com.russell._0190_reverse_bits;

/*
Reverse bits of a given 32 bits unsigned integer.

Note:

Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will
be given as a signed integer type. They should not affect your implementation, as the integer's internal binary
representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the
input represents the signed integer -3 and the output represents the signed integer -1073741825.
 */

public class Solution {
    public int reverseBits(int n) {
        // build the reversed number by shifting left 1 bit and then adding 1 if the last bit of n is 1. Then
        // shift n right (unsigned shift right because Java) 1 bit to evaluate the next
        int reverse = 0;
        for (int i = 32; i > 0; i--) {
            reverse <<= 1;
            if ( (n & 1) == 1)
                reverse += 1;
            n = n >>> 1; // unsigned right shift (doesn't preserve sign bit)
        }
        return reverse;
    }
}
