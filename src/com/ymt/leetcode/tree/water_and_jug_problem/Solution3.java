package com.ymt.leetcode.tree.water_and_jug_problem;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution3 {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        Deque<int[]> stack = new LinkedList<>();
        Set<Long> checked = new HashSet<>();
        stack.push(new int[]{0, 0});
        while (!stack.isEmpty()) {
            int[] currState = stack.pop();
            long currHash = hash(currState);
            if (checked.contains(currHash)) {
                continue;
            }
            checked.add(currHash);
            if (targetCapacity == currState[0] || targetCapacity == currState[1]
                    || targetCapacity == currState[0] + currState[1]) {
                return true;
            }
            stack.push(new int[]{jug1Capacity, currState[1]});
            stack.push(new int[]{currState[0], jug2Capacity});
            stack.push(new int[]{0, currState[1]});
            stack.push(new int[]{currState[0], 0});
            int change = Math.min(currState[0], jug2Capacity - currState[1]);
            stack.push(new int[]{currState[0] - change, currState[1] + change});
            change = Math.min(jug1Capacity - currState[0], currState[1]);
            stack.push(new int[]{currState[0] + change, currState[1] - change});
        }
        return false;
    }

    private long hash(int[] state) {
        return state[0] * 10000001l + state[1];
    }
}