package com.ymt.leetcode.tree.lowest_common_ancestor_of_a_binary_search_tree;

import com.ymt.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pParents = new ArrayList<>();
        List<TreeNode> qParents = new ArrayList<>();
        dfs(root, pParents, p.val);
        dfs(root, qParents, q.val);
        for(int i = pParents.size() - 1; i >= 0; --i){
            if(qParents.contains(pParents.get(i))){
                return pParents.get(i);
            }
        }
        return root;
    }

    private void dfs(TreeNode root, List<TreeNode> parents, int val){
        if(root == null){
            return;
        }
        parents.add(root);
        if(root.val == val){
            return;
        }else if(root.val > val){
            dfs(root.left, parents, val);
        }else{
            dfs(root.right, parents, val);
        }
    }
}