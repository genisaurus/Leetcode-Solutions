package com.russell._0235_lowest_common_ancestor_of_a_binary_search_tree;

import com.russell.common.TreeNode;

/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // helped by remembering how a BST is structured. The returned node is always going to have one node on the
        // left (lower than current value) and one node on the right (higher than current value), so if they're
        // BOTH lower or both higher, the LCA is on the left or right respectively.
        return helper(root, p, q);
    }

    TreeNode helper(TreeNode current, TreeNode p, TreeNode q) {
        if (p.val < current.val && q.val < current.val)
            return lowestCommonAncestor(current.left, p, q);
        else if (p.val > current.val && q.val > current.val)
            return lowestCommonAncestor(current.right, p, q);
        return current;
    }
}
