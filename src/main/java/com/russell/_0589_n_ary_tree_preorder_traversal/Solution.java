package com.russell._0589_n_ary_tree_preorder_traversal;

import com.russell.common.Node;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by
the null value (See examples)
 */

class Solution {
    public List<Integer> preorder(Node root) {
        // preorder traversal is easy, here we take advantage of the fact that a List's iterator
        // will iterate in index order
        List<Integer> visited = new ArrayList<>();
        if (root == null)
            return visited;
        return traverse(root, visited);
    }

    public List<Integer> traverse(Node current, List<Integer> visited) {
        visited.add(current.val);
        if (current.children != null && current.children.size() > 0)
            for(Node child : current.children)
                traverse(child, visited);
        return visited;
    }
}
