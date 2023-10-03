package com.ymt.leetcode.tree.largest_bst_subtree;

import com.ymt.leetcode.tree.TreeNode;

/**
 * 参考官方题解
 */
public class Solution4 {
    private int ans = 0;
    public int largestBSTSubtree(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return ans;
    }

    private TreeDetail dfs(TreeNode node){
        if(node.left == null && node.right == null){
            ans = Math.max(ans, 1);
            return new TreeDetail(node.val, node.val, 1);
        }

        int nodeCount = 1;
        int currMin = node.val;
        int currMax = node.val;
        boolean isBst = true;
        if(node.left != null){
            TreeDetail td = dfs(node.left);
            if(td.count > 0 && node.val > td.max){
                nodeCount += td.count;
                currMin = td.min;
            }else{
                isBst = false;
            }
        }
        if(node.right != null){
            TreeDetail td = dfs(node.right);
            if(td.count > 0 && node.val < td.min){
                nodeCount += td.count;
                currMax = td.max;
            }else{
                isBst = false;
            }
        }
        if(isBst){
            ans = Math.max(ans, nodeCount);
            return new TreeDetail(currMin, currMax, nodeCount);
        }
        return new TreeDetail(0, 0, -1);
    }

    public class TreeDetail{
        private int min;
        private int max;
        private int count;

        public TreeDetail(){}
    public TreeDetail(int min, int max, int count){
            this.min = min;
            this.max = max;
            this.count = count;
        }
    }
}