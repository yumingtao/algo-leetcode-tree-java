package com.ymt.leetcode.tree.count_complete_tree_nodes;

import com.ymt.leetcode.tree.TreeNode;

/**
 * @author yumingtao
 * @description 参考题解
 * @date 2023-06-25 17:12
 */
public class Solution2 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLevel = countLevel(root.left);
        int rightLevel = countLevel(root.right);
        if (leftLevel == rightLevel) {
            //说明最后一个节点落在右子树上，左子树是一个满二叉树
            return countNodes(root.right) + (1 << leftLevel);
        } else {
            //说明最后一个节点落在左子树上，右子树是一个满二叉树
            return countNodes(root.left) + (1 << rightLevel);
        }
    }

    private int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            ++level;
            root = root.left;
        }
        return level;
    }
}
