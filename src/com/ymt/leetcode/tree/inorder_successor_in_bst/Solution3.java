package com.ymt.leetcode.tree.inorder_successor_in_bst;

import com.ymt.leetcode.tree.TreeNode;
/**
 * 利用中序遍历
 */
public class Solution3 {
    private TreeNode pre;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null){
            return null;
        }
        TreeNode temp = inorderSuccessor(root.left, p);
        if(temp != null){
            return temp;
        }else if(pre == p){
            return root;
        }else{
            pre = root;
        }
        return inorderSuccessor(root.right, p);
    }
}