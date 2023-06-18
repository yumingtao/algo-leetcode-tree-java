package com.ymt.leetcode.tree.sum_root_to_leaf_numbers;

import com.ymt.leetcode.tree.TreeNode;

/**
 * @author yumingtao
 * @description
 * @date 2023-06-18 14:21
 */
public class Solution1 {
    private int ans = 0;

    public int sumNumbers(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return ans;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            ans += Integer.parseInt(sb.toString());
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
