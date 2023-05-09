package com.russell._0100_same_tree;

import com.russell.common.TreeNode;

/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // DFS that traverses two trees simultaneously
        return doubleDFS(p,q);
    }

    boolean doubleDFS(TreeNode p, TreeNode q) {
        // if one node is a leaf and the other isn't, these trees are not the same
        if ((p == null && q != null)
                || (p != null && q == null)) {
            return false;
        }
        // if they're both leaves, this node is valid
        if (p == null && q == null)
            return true;

        // if these nodes have different values, invalid
        if (p.val != q.val)
            return false;

        return doubleDFS(p.left,q.left) && doubleDFS(p.right,q.right);
    }
}
