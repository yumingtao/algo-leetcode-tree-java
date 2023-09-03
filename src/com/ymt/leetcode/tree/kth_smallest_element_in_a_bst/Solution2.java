package com.ymt.leetcode.tree.kth_smallest_element_in_a_bst;

import com.ymt.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    private List<Integer> values = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return values.get(k -1);
    }

    private void dfs(TreeNode root, int k){
        if(root == null || values.size() == k){
            return;
        }
        dfs(root.left, k);
        values.add(root.val);
        dfs(root.right, k);
    }
}