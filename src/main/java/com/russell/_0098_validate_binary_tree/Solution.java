package com.russell._0098_validate_binary_tree;

import com.russell.common.TreeNode;

/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        // DFS where each left node has a value less than its parent but greater than the smallest of all its parents
        // and each right node has a value greater than its parent but smaller than the largest of all its parents
        // leaves are always valid
        return dfsValidate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfsValidate(TreeNode current, long minVal, long maxVal) {
        if (current == null)
            return true;
        if (current.val >= maxVal || current.val <= minVal)
            return false;
        return dfsValidate(current.left, minVal, current.val) && dfsValidate(current.right, current.val, maxVal);
    }
}
