package com.ymt.leetcode.tree.find_leaves_of_binary_tree;

import com.ymt.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);
        int currHeight = 1 + Math.max(leftHeight, rightHeight);
        if (ans.size() == currHeight) {
            ans.add(new ArrayList<>());
        }
        ans.get(currHeight).add(node.val);
        return currHeight;
    }
}