package com.ymt.leetcode.tree.count_univalue_subtrees;

import com.ymt.leetcode.tree.TreeNode;

public class Solution1 {
    private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        isUniValue(root, -1);
        return count;
    }

    private boolean isUniValue(TreeNode root, int val){
        if(root == null){
            return true;
        }
        boolean isLeftUniValue = isUniValue(root.left, root.val);
        boolean isRightUniValue = isUniValue(root.right, root.val);
        if(!isLeftUniValue || !isRightUniValue){
            return false;
        }
        ++count;
        return root.val == val;
    }
}