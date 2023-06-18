package com.ymt.leetcode.tree.populating_next_right_pointers_in_each_node_ii;

/**
 * @author yumingtao
 * @description
 * @date 2023-06-18 13:28
 */
public class Solution1 {
    public Node connect(Node root) {
        dfs(root);
        return root;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            root.right.next = findNext(root);
            dfs(root.right);
        }
        if (root.left != null) {
            root.left.next = root.right != null ? root.right : findNext(root);
            dfs(root.left);
        }
    }

    private Node findNext(Node root) {
        Node node = root.next;
        while (node != null) {
            if (node.left == null && node.right == null) {
                node = node.next;
            } else {
                return node.left != null ? node.left : node.right;
            }
        }
        return null;
    }
}
