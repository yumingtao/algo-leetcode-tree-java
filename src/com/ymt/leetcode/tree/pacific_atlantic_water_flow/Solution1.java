package com.ymt.leetcode.tree.pacific_atlantic_water_flow;

import java.util.*;

public class Solution1 {
    //左，上，右，下
    private int[] dirX = {0, -1, 0, 1};
    private int[] dirY = {-1, 0, 1, 0};
    private int m;
    private int n;
    private Set<String> pacific = new HashSet<>();
    private Set<String> alantic = new HashSet<>();
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        //从左边界反向从边界搜索pacific
        for(int i = 0; i < m; ++i){
            dfs(heights, i, 0, pacific);
        }
        //从上边界反向搜索pacific
        for(int j = 1; j < n; ++j){
            dfs(heights, 0, j, pacific);
        }
        //从右边界反向从边界搜索alantic
        for(int i = 0; i < m; ++i){
            dfs(heights, i, n - 1, alantic);
        }
        //从下边界反向搜索alantic
        for(int j = 0; j < n; ++j){
            dfs(heights, m - 1, j, alantic);
        }

        pacific.retainAll(alantic);
        for(String position : pacific){
            String[] positionStringArray = position.split("#");
            ans.add(Arrays.asList(Integer.valueOf(positionStringArray[0]), Integer.valueOf(positionStringArray[1])));
        }
        return ans;
    }

    private void dfs(int[][] heights, int i, int j, Set<String> ocean){
        String position = i + "#" + j;
        if(ocean.contains(position)){
            return;
        }
        ocean.add(position);
        for(int k = 0; k < 4; ++k){
            int x = i + dirX[k];
            int y = j + dirY[k];
            if(x < 0 || x > m - 1 || y < 0 || y > n - 1){
                continue;
            }
            if(heights[i][j] <= heights[x][y]){
                dfs(heights, x, y, ocean);
            }
        }
    }
}