package com.russell._0088_merge_sorted_array;

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Work backwards through nums1[mid] and nums2. Add the largest vals to nums1[end]
        if (n == 0)
            return;
        if (m == 0) {
            for (int i = 0; i < n; i++)
                nums1[i] = nums2[i];
            return;
        }

        int a = m-1; // nums1 pointer
        int b = n-1; // nums2 pointer
        int c = m+n-1; // end pointer

        while (a >= 0 && b >= 0) {
            // if nums2 is getting inserted to nums1[end], decrement nums2 and nums1[end] pointers
            if(nums2[b] > nums1[a]) {
                nums1[c] = nums2[b];
                b--;
                c--;
            } else {
                // if nums1[mid] is getting inserted into nums1[end], decrement both pointers
                nums1[c] = nums1[a];
                a--;
                c--;
            }
        }
        // if we ran out of nums1[mid] numbers before nums2 numbers (nums2.length is larger), finish inserting nums2
        // to nums1
        while (b >= 0) {
            nums1[c] = nums2[b];
            b--;
            c--;
        }
    }
}
