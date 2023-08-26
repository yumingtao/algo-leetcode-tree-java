package com.ymt.leetcode.tree.minimum_absolute_difference_in_bst;

import com.ymt.leetcode.tree.TreeNode;

import java.util.Map;
import java.util.TreeMap;

public class Solution1 {
    private TreeMap<Integer, Integer> rootValues = new TreeMap();
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        int ans = Integer.MAX_VALUE;
        int preValue = -1;
        for(Map.Entry<Integer, Integer> entry : rootValues.entrySet()){
            if(preValue == -1){
                preValue = entry.getValue();
                continue;
            }
            ans = Math.min(ans, Math.abs(entry.getValue() - preValue));
            preValue = entry.getValue();
        }
        return ans;
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        rootValues.put(root.val, root.val);
        dfs(root.left);
        dfs(root.right);
    }
}