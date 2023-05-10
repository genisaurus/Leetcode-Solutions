package com.russell._0202_happy_number;

/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle
which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.
 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        // track which numbers have appeared by adding them to a set. At the first repeat number, this is
        // not a happy number. If you eventually hit 1, it's happy
        if (n == 1)
            return true;
        Set<Integer> seenNums = new HashSet<>();
        while (n != 1 && seenNums.add(n)) {
            int sum = 0;
            while (n > 0) {
                sum += Math.pow(n%10,2);
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}
