package com.ymt.leetcode.tree.flatten_binary_tree_to_linked_list;

import com.ymt.leetcode.tree.TreeNode;

/**
 * @author yumingtao
 * @description
 * @date 2023-06-11 15:26
 */
public class Solution2 {
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode next = current.left;
                TreeNode temp = next;
                //当前左子树的最右节点a如果存在，a是最后一个被访问的节点
                //a 是当前节点右节点的前驱节点
                while (temp.right != null) {
                    temp = temp.right;
                }
                //当前左子树的最右节点a如果不存在，那么当前节点的左节点 b
                //b 是当前节点右节点的前驱节点
                temp.right = current.right;
                current.left = null;
                current.right = next;
            }
            current = current.right;
        }
    }
}
