package com.ymt.leetcode.tree.kth_smallest_element_in_a_bst;

import com.ymt.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;
/**
 * 官方题解 2 简化版
 */
public class Solution4 {
    private Map<TreeNode, Integer> countMap = new HashMap<>();
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = root;
        while(node != null){
            int leftCount = countNode(node.left);
            if(leftCount == k - 1){
                //当前节点就是要找的节点
                break;
            }else if(leftCount < k - 1){
                //要找的 node 在右侧
                node = node.right;
                k = k - 1 - leftCount;
            }else{
                //要找的 node 在左侧
                node = node.left;
            }
        }
        return node.val;
    }

    private int countNode(TreeNode root){
        if(root == null){
            return 0;
        }
        int count = countNode(root.left) + countNode(root.right) + 1;
        countMap.put(root, count);
        return count;
    }
}