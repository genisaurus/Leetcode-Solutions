package com.russell._0200_number_of_islands;

/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.
 */

class Solution {
    public int numIslands(char[][] grid) {
        // search the grid in a nested-for loop for the start of an island. When one is found, use a 4-way DFS to
        // convert every cell in the island to water, so it's not counted multiple times.
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] map, int i, int j) {
        // if we're out of bounds or not in an island cell, skip
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length || map[i][j] != '1')
            return;

        map[i][j] = '0';

        dfs(map, i+1, j);
        dfs(map, i-1, j);
        dfs(map, i, j+1);
        dfs(map, i, j-1);
    }


}
