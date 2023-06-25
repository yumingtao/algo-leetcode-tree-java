package com.ymt.leetcode.tree.binary_tree_upside_down;

import com.ymt.leetcode.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yumingtao
 * @description
 * @date 2023-06-25 14:32
 */
public class Solution1 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        TreeNode newRoot = stack.peek();
        while (!stack.isEmpty()) {
            TreeNode curr = stack.poll();
            if (!stack.isEmpty()) {
                TreeNode currParent = stack.peek();
                curr.right = currParent;
                curr.left = currParent.right;

            } else {
                curr.left = null;
                curr.right = null;
            }
        }
        return newRoot;
    }
}
