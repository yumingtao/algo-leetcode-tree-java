package com.ymt.leetcode.tree.lexicographical_numbers;

import java.util.List;
/**
 * 题解实现
 */
public class Solution2 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int currNumber = 1;
        for(int i = 0; i < n; ++i){
            ans.add(currNumber);
            if(currNumber * 10 <= n){
                currNumber *= 10;
            }else{
                while(currNumber % 10 == 9 || currNumber >= n){
                    currNumber /= 10;
                }
                ++currNumber;
            }
        }
        return ans;
    }
}