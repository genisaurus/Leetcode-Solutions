package com.russell._0733_flood_fill;

/*
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the
pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel
of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels
(also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.
 */

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // similar to 200. number of islands, except you start on an "island" defined by the value at the cell given
        // check to make sure you're not out of bounds or on wrong color, and then recursively preorder traverse
        if (image[sr][sc] == newColor)
            return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fill(int[][] image, int i, int j, int original, int newColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != original)
            return;
        image[i][j] = newColor;
        fill(image, i+1, j, original, newColor);
        fill(image, i-1, j, original, newColor);
        fill(image, i, j+1, original, newColor);
        fill(image, i, j-1, original, newColor);
    }

}
