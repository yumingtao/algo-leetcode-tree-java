package com.ymt.leetcode.tree.largest_bst_subtree;

import com.ymt.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxBstNodes = findMaxBstNodes(root);
        //如果maxBstNodes=0，说明不是 BST, 分别去左右子树寻找
        return maxBstNodes == 0 ? Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right)) : maxBstNodes;
    }

    private int findMaxBstNodes(TreeNode node) {
        List<Integer> nodeValues = inorderTraversal(node, new ArrayList<>());
        for (int i = 1; i < nodeValues.size(); ++i) {
            if (nodeValues.get(i) <= nodeValues.get(i - 1)) {
                return 0;
            }
        }
        return nodeValues.size();
    }

    private List<Integer> inorderTraversal(TreeNode node, List<Integer> nodeValues) {
        if (node == null) {
            return nodeValues;
        }
        inorderTraversal(node.left, nodeValues).add(node.val);
        return inorderTraversal(node.right, nodeValues);
    }
}