package com.ymt.leetcode.tree.populating_next_right_pointers_in_each_node;

/**
 * @author yumingtao
 * @description
 * @date 2023-06-11 16:13
 */
public class Solution1 {
    public Node connect(Node root) {
        dfs(root);
        return root;
    }

    private void dfs(Node node){
        if(node == null || node.left == null){
            return;
        }
        node.left.next = node.right;
        if(node.next != null){
            node.right.next = node.next.left;
        }
        dfs(node.left);
        dfs(node.right);
    }
}
