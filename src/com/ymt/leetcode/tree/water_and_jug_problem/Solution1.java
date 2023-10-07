package com.ymt.leetcode.tree.water_and_jug_problem;

public class Solution1 {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        int max = Math.max(jug1Capacity, jug2Capacity);
        int min = Math.min(jug1Capacity, jug2Capacity);

        int total = max + min;
        while(total != 0){
            if(total == targetCapacity){
                return true;
            }

            if(total >= min){
                total -= min;
            }else{
                total += max;
            }
        }
        return false;
    }
}