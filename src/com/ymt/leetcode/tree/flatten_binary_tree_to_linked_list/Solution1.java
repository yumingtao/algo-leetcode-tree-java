package com.ymt.leetcode.tree.flatten_binary_tree_to_linked_list;

import com.ymt.leetcode.tree.TreeNode;

/**
 * @author yumingtao
 * @description 优化，可以直接使用 List 保存每次遍历的节点，然后再处理
 * @date 2023-06-11 14:48
 */
public class Solution1 {
    private TreeNode ans = new TreeNode();

    public void flatten(TreeNode root) {
        TreeNode head = ans;
        dfs(root);
        TreeNode prev = root;
        while (head.right != null) {
            prev.right = head.right.right;
            prev.left = null;
            prev = prev.right;
            head = head.right;
        }
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.right = new TreeNode(root.val, null, null);
        ans = ans.right;
        dfs(root.left);
        dfs(root.right);
    }
}
