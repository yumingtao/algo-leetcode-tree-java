package com.ymt.leetcode.tree.binary_tree_right_side_view;

import com.ymt.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yumingtao
 * @description
 * @date 2023-06-25 16:03
 */
public class Solution1 {
    private final Map<Integer, Integer> levelMap = new LinkedHashMap<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(0, root);
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : levelMap.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    private void dfs(Integer level, TreeNode root) {
        if (root == null) {
            return;
        }
        levelMap.put(level, root.val);
        dfs(level + 1, root.left);
        dfs(level + 1, root.right);
    }
}
