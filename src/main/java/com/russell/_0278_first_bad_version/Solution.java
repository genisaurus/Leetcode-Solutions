package com.russell._0278_first_bad_version;

/* You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version
of your product fails the quality check. Since each version is developed based on the previous version, all the
versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following
ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the
first bad version. You should minimize the number of calls to the API.
*/

import com.russell.common.VersionControl;

public class Solution extends VersionControl {
    // modified binary search, except what we're searching for is the last good version, which will eventually be
    // low, but after the BS mod low will point to the next version, the first bad one
    public int firstBadVersion(int n) {
        int low = 1, mid=0;

        while (low <= n) {
            mid = low + (n-low)/2;
            if (isBadVersion(mid))
                n = mid-1;
            else
                low = mid+1;
        }

        return low;
    }
}
