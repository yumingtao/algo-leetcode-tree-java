package com.ymt.leetcode.tree.kth_smallest_element_in_a_bst;

import com.ymt.leetcode.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution3 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            --k;
            if(k == 0){
                break;
            }
            node = node.right;
        }
        return node.val;
    }
}