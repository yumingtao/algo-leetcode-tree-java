package com.ymt.leetcode.tree.recover_binary_search_tree;

import com.ymt.leetcode.tree.TreeNode;

public class Solution1 {
    private TreeNode pre = null;
    private TreeNode firstMax = null;
    private TreeNode lastMin = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        if(firstMax != null && lastMin != null){
            int t = lastMin.val;
            lastMin.val = firstMax.val;
            firstMax.val = t;
        }
    }

    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(pre != null){
            if(pre.val > root.val){
                lastMin = root;
                if(firstMax == null){
                    firstMax = pre;
                }
            }
        }
        pre = root;
        inorder(root.right);
    }
}