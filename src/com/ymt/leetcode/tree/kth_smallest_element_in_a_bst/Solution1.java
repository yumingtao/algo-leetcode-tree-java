package com.ymt.leetcode.tree.kth_smallest_element_in_a_bst;

import com.ymt.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    private List<Integer> values = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        if(values.size() == k){
            return values.get(k - 1);
        }
        if(root == null){
            return -1;
        }
        if(kthSmallest(root.left, k) == -1){
            values.add(root.val);
        }
        return kthSmallest(root.right, k);
    }
}