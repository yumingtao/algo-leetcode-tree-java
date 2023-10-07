package com.ymt.leetcode.tree.find_leaves_of_binary_tree;

import com.ymt.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        while(root != null){
            List<Integer> leaves = new ArrayList<>();
            root = dfs(root, leaves);
            ans.add(leaves);
        }
        return ans;
    }

    private TreeNode dfs(TreeNode node, List<Integer> leaves){
        if(node == null){
            return null;
        }
        if(node.left == null && node.right == null){
            leaves.add(node.val);
            return null;
        }
        node.left = dfs(node.left, leaves);
        node.right = dfs(node.right, leaves);
        return node;
    }
}