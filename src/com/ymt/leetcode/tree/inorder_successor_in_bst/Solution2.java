package com.ymt.leetcode.tree.inorder_successor_in_bst;

import com.ymt.leetcode.tree.TreeNode;
/**
 * 题解方法 2
 */
public class Solution2 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        if(p.right != null){
            successor = p.right;
            while(successor.left != null){
                successor = successor.left;
            }
            return successor;
        }
        TreeNode node = root;
        while(node != null){
            if(node.val > p.val){
                successor = node;
                node = node.left;
            }else{
                node = node.right;
            }
        }
        return successor;
    }
}