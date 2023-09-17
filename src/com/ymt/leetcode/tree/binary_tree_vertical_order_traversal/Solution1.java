package com.ymt.leetcode.tree.binary_tree_vertical_order_traversal;

import com.ymt.leetcode.tree.TreeNode;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Solution1 {
    private final Map<Integer, ArrayList<Entry<Integer, Integer>>> columnTable = new HashMap<>();
    private int minColumn = 0;
    private int maxColumn = 0;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        //前序 dfs，将每个节点的值映射到矩阵
        dfs(root, 0, 0);
        for(int i = minColumn; i <= maxColumn; ++i){
            columnTable.get(i).sort(Comparator.comparingInt(Entry::getKey));
            ans.add(columnTable.get(i).stream().map(Entry::getValue).collect(Collectors.toCollection(ArrayList::new)));
        }
        return ans;
    }

    private void dfs(TreeNode node, int currColumn, int currRow){
        if(node == null){
            return;
        }
        columnTable.putIfAbsent(currColumn, new ArrayList<>());
        columnTable.get(currColumn).add(new AbstractMap.SimpleEntry<>(currRow, node.val));
        minColumn = Math.min(minColumn, currColumn);
        maxColumn = Math.max(maxColumn, currColumn);
        dfs(node.left, currColumn - 1, currRow + 1);
        dfs(node.right, currColumn + 1, currRow + 1);
    }
}