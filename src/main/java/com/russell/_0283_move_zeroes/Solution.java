package com.russell._0283_move_zeroes;

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero
elements.

Note that you must do this in-place without making a copy of the array.
 */

class Solution {
    public void moveZeroes(int[] nums) {
        // 2-pointer solution sends pA and pB out, with pB looking ahead.
        // pA finds the next 0, and pB finds the next number after pA that isn't a 0. Then they swap values.
        // pB only increments after a swap or when it has fallen behind pA.
        if (nums.length == 1)
            return;
        int pA = 0;
        int pB = 1;
        while (pB < nums.length && pA < nums.length) {
            if (nums[pB] == 0 || pB <= pA) {
                pB++;
            } else if (nums[pA] == 0) {
                nums[pA] = nums[pB];
                nums[pB] = 0;
                pA++;
                pB++;
            } else {
                pA++;
            }

        }
        /*
        // for study: snowball/variable shifting window solution
        // Zeroes snowball as you swap 0's and !0's, so always swap with
        // first index of the snowball
        int snowBallSize = 0;
        for (int i=0;i<nums.length;i++){
	        if (nums[i]==0){
                snowBallSize++;
            }
            else if (snowBallSize > 0) {
	            int t = nums[i];
	            nums[i]=0;
	            nums[i-snowBallSize]=t;
            }
        }
        */
    }
}
