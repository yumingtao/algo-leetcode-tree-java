package com.ymt.leetcode.tree.house_robber_iii;

import com.ymt.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 参考题解
 */
public class Solution1 {
    private Map<TreeNode, Integer> select = new HashMap<>();
    private Map<TreeNode, Integer> unSelect = new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        //返回根节点选中和不选中的最大值
        return Math.max(select.getOrDefault(root, 0), unSelect.getOrDefault(root, 0));
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        //node被选中，则value应该是当前节点的值 + 左右两个节点都不能被选中时的值
        select.put(node, node.val + unSelect.getOrDefault(node.left, 0) + unSelect.getOrDefault(node.right, 0));
        //node节点没有选中, 怎value应该是左节点选中或不被选中的最大值 + 右节点选中或不被选中的最大值
        unSelect.put(node, Math.max(select.getOrDefault(node.left, 0), unSelect.getOrDefault(node.left, 0))
                + Math.max(select.getOrDefault(node.right, 0), unSelect.getOrDefault(node.right, 0)));
    }
}