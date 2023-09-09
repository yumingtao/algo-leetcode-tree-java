package com.ymt.leetcode.tree.count_univalue_subtrees;

import com.ymt.leetcode.tree.TreeNode;

public class Solution2 {
    private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null){
            return 0;
        }
        isUniValue(root);
        return count;
    }

    private boolean isUniValue(TreeNode root){
        if(root.left == null && root.right == null){
            ++count;
            return true;
        }
        boolean isLeftUni = true;
        if(root.left != null){
            isLeftUni = isUniValue(root.left) && root.left.val == root.val;
        }
        boolean isRightUni = true;
        if(root.right != null){
            isRightUni = isUniValue(root.right) && root.right.val == root.val;
        }
        if(!isLeftUni || !isRightUni){
            return false;
        }
        ++count;
        return true;
    }
}