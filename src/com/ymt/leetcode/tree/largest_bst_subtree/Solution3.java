package com.ymt.leetcode.tree.largest_bst_subtree;

import com.ymt.leetcode.tree.TreeNode;

/**
 * 参看题解
 */
public class Solution3 {
    private TreeNode pre;

    public int largestBSTSubtree(TreeNode root) {
        pre = null;
        if (root == null) {
            return 0;
        }
        if (isBst(root)) {
            return count(root);
        }
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private boolean isBst(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (!isBst(node.left)) {
            return false;
        }
        if (pre != null && pre.val >= node.val) {
            return false;
        }
        pre = node;
        return isBst(node.right);
    }

    private int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return count(node.left) + count(node.right) + 1;
    }
}