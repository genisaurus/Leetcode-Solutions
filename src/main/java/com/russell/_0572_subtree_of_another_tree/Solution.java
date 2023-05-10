package com.russell._0572_subtree_of_another_tree;

import com.russell.common.TreeNode;

/*
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same
structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The
tree 'tree' could also be considered as a subtree of itself.
 */

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // two parts to this: 1) recursive traversal function to ensure two given trees are the same, and
        // 2) a recursive traversal function to check whether two given subtrees are the same (using #1)
        // Main function traverses the first tree, and checks if the subtree below each node is the same
        // as the given subtree. checks left and right trees separately.
        if (root == null) return false;
        if (isSame(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
