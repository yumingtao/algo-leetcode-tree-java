package com.ymt.leetcode.tree.count_complete_tree_nodes;

import com.ymt.leetcode.tree.TreeNode;

/**
 * @author yumingtao
 * @description 普适解法
 * @date 2023-06-25 16:31
 */
public class Solution1 {
    private int ans = 0;

    public int countNodes(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        ans++;
        dfs(root.left);
        dfs(root.right);
    }
}
