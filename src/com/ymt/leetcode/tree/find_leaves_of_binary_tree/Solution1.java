package com.ymt.leetcode.tree.find_leaves_of_binary_tree;

import com.ymt.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution1 {
    private List<Pair> nodeHeights = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        dfs(root);
        nodeHeights.sort(Comparator.comparingInt(p -> p.getKey()));
        int height = 0;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        for (Pair p : nodeHeights) {
            if (p.getKey() == height) {
                nums.add(p.getValue());
                continue;
            }
            ans.add(nums);
            nums = new ArrayList();
            nums.add(p.getValue());
            ++height;
        }
        ans.add(nums);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);
        int currHeight = 1 + Math.max(leftHeight, rightHeight);
        nodeHeights.add(new Pair(currHeight, node.val));
        return currHeight;
    }

    public class Pair {
        private Integer key;
        private Integer value;

        public Pair() {
        }

        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return this.key;
        }

        public Integer getValue() {
            return this.value;
        }
    }
}