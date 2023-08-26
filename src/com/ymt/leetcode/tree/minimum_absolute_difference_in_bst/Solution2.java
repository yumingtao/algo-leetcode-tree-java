package com.ymt.leetcode.tree.minimum_absolute_difference_in_bst;

import com.ymt.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    private List<Integer> rootValues = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < rootValues.size(); ++i){
            ans = Math.min(ans, Math.abs(rootValues.get(i) - rootValues.get(i - 1)));    
        }
        return ans;
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        rootValues.add(root.val);
        dfs(root.right);
    }
}