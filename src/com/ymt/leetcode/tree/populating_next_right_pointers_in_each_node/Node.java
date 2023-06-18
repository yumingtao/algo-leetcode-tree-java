package com.ymt.leetcode.tree.populating_next_right_pointers_in_each_node;

/**
 * @author yumingtao
 * @description
 * @date 2023-06-11 16:15
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
