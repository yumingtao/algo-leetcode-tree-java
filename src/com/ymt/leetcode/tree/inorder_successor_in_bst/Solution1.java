package com.ymt.leetcode.tree.inorder_successor_in_bst;

import com.ymt.leetcode.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution1 {
    private TreeNode successor;
    private Deque<TreeNode> pParents = new LinkedList<>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root, p.val, true, null);
        return successor;
    }

    private void dfs(TreeNode curr, int val, boolean isLeft, TreeNode currParent){
        if(curr == null){
            return;
        }
        if(curr.val == val){
            if(curr.right == null){
                successor = isLeft ? currParent : pParents.isEmpty() ? null : pParents.pop();
            }else{
                TreeNode temp = curr.right;
                while(temp.left != null){
                    temp = temp.left;
                } 
                successor = temp;
            }
        }else if(curr.val > val){
            pParents.push(curr);
            dfs(curr.left, val, true, curr);
        }else{
            dfs(curr.right, val, false, curr);
        }
    }
}