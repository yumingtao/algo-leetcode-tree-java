package com.ymt.leetcode.tree.water_and_jug_problem;

public class Solution2 {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity > jug1Capacity + jug2Capacity) {
            return false;
        }
        return targetCapacity == jug1Capacity + jug2Capacity || targetCapacity % getGcd(jug1Capacity, jug2Capacity) == 0;
    }

    private int getGcd(int x, int y) {
        int reminder = x % y;
        while (reminder != 0) {
            x = y;
            y = reminder;
            reminder = x % y;
        }
        return y;
    }
}