package com.ymt.leetcode.tree.diameter_of_binary_tree;

import com.ymt.leetcode.tree.TreeNode;

public class Solution1 {
    private int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        ans = Math.max(ans, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}