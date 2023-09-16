package com.ymt.leetcode.tree.binary_tree_longest_consecutive_sequence;

import com.ymt.leetcode.tree.TreeNode;

public class Solution2 {
    public int longestConsecutive(TreeNode root) {
        return calculatePath(root, null, 0);
    }

    private int calculatePath(TreeNode node, TreeNode parent, int path){
        if(node == null){
            return 0;
        }
        int currPath = (parent != null && node.val == parent.val + 1) ? path + 1 : 1;
        int leftPath = calculatePath(node.left, node, currPath);
        int rightPath = calculatePath(node.right, node, currPath);
        return Math.max(currPath, Math.max(leftPath, rightPath));
    }
}