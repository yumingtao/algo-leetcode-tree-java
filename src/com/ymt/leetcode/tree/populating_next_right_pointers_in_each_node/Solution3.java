package com.ymt.leetcode.tree.populating_next_right_pointers_in_each_node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yumingtao
 * @description BFS
 * @date 2023-06-11 16:44
 */
public class Solution3 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
