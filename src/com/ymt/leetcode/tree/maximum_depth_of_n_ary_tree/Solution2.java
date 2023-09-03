package com.ymt.leetcode.tree.maximum_depth_of_n_ary_tree;

import com.ymt.leetcode.tree.Node;

public class Solution2 {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int maxChildDepth = 0;
        for(Node node : root.children){
            maxChildDepth = Math.max(maxChildDepth, maxDepth(node));
        }
        return maxChildDepth + 1;
    }
}