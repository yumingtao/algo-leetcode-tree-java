package com.ymt.leetcode.tree.minimum_absolute_difference_in_bst;

import com.ymt.leetcode.tree.TreeNode;

public class Solution3 {
    private int ans = Integer.MAX_VALUE;
    private int preRootValue = -1;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        if(preRootValue == -1 ){
            preRootValue = root.val;
        }else{
            ans = Math.min(ans, Math.abs(root.val - preRootValue));
            preRootValue = root.val;
        }
        dfs(root.right);
    }
}