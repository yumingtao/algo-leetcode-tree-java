package com.ymt.leetcode.tree.path_sum_ii;

import com.ymt.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yumingtao
 * @description
 * @date 2023-06-11 12:55
 */
public class Solution2 {
    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        hasPathSum(root, targetSum, path);
        return ans;
    }

    private void hasPathSum(TreeNode root, int targetSum, List<Integer> path) {
        if (root == null) {
            return;
        }
        targetSum = targetSum - root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum == 0) {
            ans.add(new ArrayList<>(path));
        }
        hasPathSum(root.left, targetSum, path);
        hasPathSum(root.right, targetSum, path);
        //遍历完当前节点，还原 path
        if (!path.isEmpty()) path.remove(path.size() - 1);
    }
}
