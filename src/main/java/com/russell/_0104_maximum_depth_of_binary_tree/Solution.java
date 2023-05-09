package com.russell._0104_maximum_depth_of_binary_tree;

import com.russell.common.TreeNode;

/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest
leaf node.
 */

class Solution {
    public int maxDepth(TreeNode root) {
        // just a DFS where the current depth is passed along as a parameter, so the return is the max of all depths
        // found on a given branch
        if (root == null)
            return 0;
        return dfsDepth(root, 1);
    }

    int dfsDepth(TreeNode node, int maxDepth) {
        int leftDepth = maxDepth;
        int rightDepth = maxDepth;
        if (node.left != null)
            leftDepth = dfsDepth(node.left, maxDepth+1);
        if (node.right != null)
            rightDepth = dfsDepth(node.right, maxDepth+1);

        return Math.max(leftDepth, rightDepth);
    }
}
