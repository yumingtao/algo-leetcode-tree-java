package com.ymt.leetcode.tree.sum_root_to_leaf_numbers;

import com.ymt.leetcode.tree.TreeNode;

/**
 * @author yumingtao
 * @description 题解方案
 * @date 2023-06-18 14:28
 */
public class Solution2 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return dfs(root.left, sum) + dfs(root.right, sum);
    }
}
