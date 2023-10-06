package com.ymt.leetcode.tree.house_robber_iii;

import com.ymt.leetcode.tree.TreeNode;

/**
 * 参考题解
 */
public class Solution2 {
    public int rob(TreeNode root) {
        //二维数组，0-未被打劫，1-被打劫
        int[] rootResults = dfs(root);
        return Math.max(rootResults[0], rootResults[1]);
    }

    private int[] dfs(TreeNode node){
        if(node == null){
            return new int[]{0, 0};
        }
        int[] leftResults = dfs(node.left);
        int[] rightResults = dfs(node.right);
        int[] currResults = new int[2];
        currResults[0] = Math.max(leftResults[0], leftResults[1]) + Math.max(rightResults[0], rightResults[1]);
        currResults[1] = node.val + leftResults[0] + rightResults[0];
        return currResults;
    }
}