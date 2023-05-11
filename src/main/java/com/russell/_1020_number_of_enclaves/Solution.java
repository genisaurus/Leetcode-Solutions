package com.russell._1020_number_of_enclaves;

/*
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the
boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
 */

class Solution {
    public int numEnclaves(int[][] grid) {
        // similar to 200. Number of Islands, except you're just deleting islands along the border and counting
        // the remaining land cells
        int m = grid.length;
        int n = grid[0].length;
        int s = 0;

        // purge islands that touch the borders. 4x for-loops is faster than a nested for
        //top
        for (int i = 0; i < n; i++)
            delete(grid, 0, i, m, n);
        //right
        for (int i = 0; i < m; i++)
            delete(grid, i, n-1, m, n);
        //bottom
        for (int i = 0; i < n; i++)
            delete(grid, m-1, i, m, n);
        //left
        for (int i = 0; i < m; i++)
            delete(grid, i, 0, m, n);

        // count remaining cells
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                s += grid[i][j];

        return s;
    }

    public void delete(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0)
            return;
        else {
            grid[i][j] = 0;
            delete(grid, i-1, j, m, n);
            delete(grid, i+1, j, m, n);
            delete(grid, i, j-1, m, n);
            delete(grid, i, j+1, m, n);
        }
    }
}
