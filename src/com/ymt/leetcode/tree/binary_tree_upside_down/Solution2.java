package com.ymt.leetcode.tree.binary_tree_upside_down;

import com.ymt.leetcode.tree.TreeNode;

/**
 * @author yumingtao
 * @description 参考题解
 * @date 2023-06-25 15:01
 */
public class Solution2 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode currRoot = null;
        TreeNode currRootRight = null;
        while (curr != null) {
            TreeNode currRootLeft = curr.left;
            curr.left = currRootRight;
            currRootRight = curr.right;
            curr.right = currRoot;
            currRoot = curr;
            curr = currRootLeft;
        }
        return currRoot;
    }
}
