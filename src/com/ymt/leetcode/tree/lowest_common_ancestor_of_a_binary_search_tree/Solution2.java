package com.ymt.leetcode.tree.lowest_common_ancestor_of_a_binary_search_tree;

import com.ymt.leetcode.tree.TreeNode;

public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while(true){
            if(ancestor.val < p.val && ancestor.val < q.val){
                ancestor = ancestor.right;
            }else if (ancestor.val > p.val && ancestor.val > q.val){
                ancestor = ancestor.left;
            }else{
                break;
            }
        }
        return ancestor;
    }
}