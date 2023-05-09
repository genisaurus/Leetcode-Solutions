package com.russell._0102_binary_tree_level_order_traversal;

import com.russell.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, return the level order traversal of its nodes' values.
(i.e., from left to right, level by level).
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // DFS traversal, but the results are basically a BFS queue. Because the output is a List<Nodes at each depth>
        // the index of the outer list refers to the depth. So we can do a DFS and just pull the current node list
        // for a given depth so long as that's a separate parameter
        List<List<Integer>> output = new ArrayList<>();
        if (root == null)
            return output;
        return bfs(root, output, 0);
    }

    public List<List<Integer>> bfs(TreeNode current, List<List<Integer>> output, int level) {
        // if this is a new level, add a new List of nodes at this level to the List of levels, else get the List for
        // this depth level
        List<Integer> nodeVals;
        if (output.size() <= level) {
            nodeVals = new ArrayList<>();
            output.add(nodeVals);
        } else
            nodeVals = output.get(level);

        nodeVals.add(current.val);

        if (current.left != null)
            bfs(current.left, output, level+1);
        if (current.right != null)
            bfs(current.right, output, level+1);

        return output;
    }
}
