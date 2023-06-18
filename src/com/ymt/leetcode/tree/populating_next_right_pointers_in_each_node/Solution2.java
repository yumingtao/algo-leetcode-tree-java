package com.ymt.leetcode.tree.populating_next_right_pointers_in_each_node;

/**
 * @author yumingtao
 * @description
 * @date 2023-06-11 16:30
 */
public class Solution2 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        //遍历每一层左节点为头节点的链表
        Node left = root;
        while (left.left != null) {
            //遍历链表
            Node head = left;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            left = left.left;
        }
        return root;
    }
}
