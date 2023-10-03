package com.ymt.leetcode.tree.largest_bst_subtree;

import com.ymt.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    private List<TreeDetail> nodes = new ArrayList<>();

    public int largestBSTSubtree(TreeNode root) {
        checkBST(root);
        int ans = 0;
        for (TreeDetail node : nodes) {
            if (node.isBst) {
                ans = Math.max(ans, node.getNodeCount());
            }
        }
        return ans;
    }

    private boolean checkBST(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean isLeftBst = checkBST(node.left);
        boolean isRightBst = checkBST(node.right);
        boolean isBst = false;
        if (isLeftBst && isRightBst) {
            int leftMaxVal = getMaxVal(node.left, Integer.MIN_VALUE);
            int rightMinVal = getMinVal(node.right, Integer.MAX_VALUE);
            if (node.val > leftMaxVal && node.val < rightMinVal) {
                isBst = true;
            }
        }
        TreeDetail treeDetail = new TreeDetail(node, isBst);
        nodes.add(treeDetail);
        return isBst;
    }

    private int getMaxVal(TreeNode node, int maxValue) {
        if (node == null) {
            return maxValue;
        }
        maxValue = Math.max(maxValue, node.val);
        return Math.max(getMaxVal(node.left, maxValue), getMaxVal(node.right, maxValue));
    }

    private int getMinVal(TreeNode node, int minValue) {
        if (node == null) {
            return minValue;
        }
        minValue = Math.min(minValue, node.val);
        return Math.min(getMinVal(node.left, minValue), getMinVal(node.right, minValue));
    }

    class TreeDetail {
        private TreeNode node;
        //以 node 为根节点的树是否是 BST
        private boolean isBst;

        public TreeDetail() {
        }

        public TreeDetail(TreeNode node, boolean isBst) {
            this.node = node;
            this.isBst = isBst;
        }

        public int getNodeCount() {
            return countNodes(this.node);
        }

        private int countNodes(TreeNode node) {
            return node == null ? 0 : countNodes(node.left) + countNodes(node.right) + 1;
        }
    }
}