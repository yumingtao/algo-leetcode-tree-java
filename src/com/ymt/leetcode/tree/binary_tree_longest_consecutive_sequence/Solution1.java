package com.ymt.leetcode.tree.binary_tree_longest_consecutive_sequence;

import com.ymt.leetcode.tree.TreeNode;

public class Solution1 {
    private int ans = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root, 1);
        return ans;
    }

    private void dfs(TreeNode root, int path){
        if(root == null){
            return;
        }
        if(root.left != null && root.val == root.left.val - 1){
            dfs(root.left, path + 1);
        }else{
            dfs(root.left, 1);
        }
        ans = Math.max(ans, path);
        if(root.right != null && root.val == root.right.val - 1){
            dfs(root.right, path + 1);
        }else{
            dfs(root.right, 1);
        }
        ans = Math.max(ans, path);
    }
}