package com.ymt.leetcode.tree.path_sum_ii;

import com.ymt.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yumingtao
 * @description
 * @date 2023-06-11 12:51
 */
public class Solution1 {
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
        //如果是叶子节点
        if (root.left == null && root.right == null) {
            //路径总和不满足要求，直接返回
            if (targetSum != 0) {
                return;
            }
            //路径总和满足要求，将 path 中的值赋给一个临时List
            path.add(root.val);
            ans.add(new ArrayList<>(path));
            //设置完 ans 要还原 path
            if (!path.isEmpty()) path.remove(path.size() - 1);
            return;
        }
        path.add(root.val);
        hasPathSum(root.left, targetSum, path);
        hasPathSum(root.right, targetSum, path);
        //遍历完当前节点，还原 path
        if (!path.isEmpty()) path.remove(path.size() - 1);
    }
}
