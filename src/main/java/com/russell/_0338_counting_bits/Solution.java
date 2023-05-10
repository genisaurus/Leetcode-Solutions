package com.russell._0338_counting_bits;

/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of
1's in the binary representation of i.
 */

class Solution {
    public int[] countBits(int n) {
        // had to work this one out on paper to recognize patterns in bits. the number of bits in each value i is going
        // to be the same as the number of bits in i>>1, plus i&1
        /*
            ans[1]  0001 = (ans[0]==0) + (0001 & 1 == 1) -> 0+1 = 1
            ans[2]  0010 = (ans[1]==1) + (0010 & 1 == 0) -> 1+0 = 0
            ans[3]  0011 = (ans[1]==1) + (0011 & 1 == 1) -> 1+1 = 2
            ...
            ans[6]  0110 = (ans[3]==2) + (0110 & 1 == 0) -> 2+0 = 2
            ...
            ans[13] 1101 = (ans[6]==2) + (1101 & 1 == 1) -> 2+1 = 3
*/
        int[] ans = new int[n+1];
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
