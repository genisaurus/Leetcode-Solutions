package com.russell._0226_invert_binary_tree;

import com.russell.common.TreeNode;

/*
Given the root of a binary tree, invert the tree, and return its root.
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        // I realize I have a habit of referring to a pre-order traversal as "dfs", which is not correct.
        // but anyway, use a pre-order traversal to swap left and right child nodes from the bottom-up
        if (root == null)
            return root;
        dfsInvert(root);
        return root;
    }

    void dfsInvert(TreeNode node) {
        if (node.left != null)
            dfsInvert(node.left);
        if (node.right != null)
            dfsInvert(node.right);

        TreeNode t = node.right;
        node.right = node.left;
        node.left = t;
    }
}
