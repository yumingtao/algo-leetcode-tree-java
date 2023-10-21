package com.ymt.leetcode.tree.lexicographical_numbers;

import java.util.ArrayList;
import java.util.List;
/**
 * DFS实现
 */
public class Solution1 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        dfs(0, n, ans);
        return ans;
    }

    private void dfs(int currNumber, int n, List<Integer> ans) {
        if (currNumber > n) {
            return;
        }
        if (currNumber > 0) {
            ans.add(currNumber);
        }
        for (int i = 0; i <= 9; i++) {
            int next = currNumber * 10 + i;
            if (next == 0) {
                continue;
            }
            dfs(next, n, ans);
        }
    }
}