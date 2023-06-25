package com.ymt.leetcode.tree.binary_tree_upside_down;

import com.ymt.leetcode.tree.TreeNode;

/**
 * @author yumingtao
 * @description 参考题解
 * @date 2023-06-25 15:27
 */
public class Solution3 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return dfs(null, root);
    }

    private TreeNode dfs(TreeNode currRoot, TreeNode curr) {
        // dfs找到新的root节点，在每一层递归结束时返回
        TreeNode newRoot = curr.left == null ? curr : dfs(curr, curr.left);
        // 自底向上处理每个 curr节点
        if (currRoot != null) {
            curr.right = currRoot;
            curr.left = currRoot.right;
            currRoot.left = null;
            currRoot.right = null;
        }

        return newRoot;
    }
}
