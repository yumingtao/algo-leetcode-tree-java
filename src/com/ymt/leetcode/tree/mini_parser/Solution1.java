package com.ymt.leetcode.tree.mini_parser;

public class Solution1 {
    private int index = 0;
    public NestedInteger deserialize(String s) {
        char ch = s.charAt(index);
        if(ch != '['){
            int start = index;
            int flag = 1;
            if(s.charAt(index) == '-'){
                flag = -1;
                ++start;
                ++index;
            }
            while(index < s.length()){
                if(!Character.isDigit(s.charAt(index))){
                    break;
                }
                ++index;
            }
            return new NestedInteger(flag * Integer.valueOf(s.substring(start, index)));
        }else{
            ++index;
            NestedInteger ni = new NestedInteger();
            while(s.charAt(index) != ']'){
                ni.add(deserialize(s));
                if(s.charAt(index) == ','){
                    ++index;
                }
            }
            ++index;
            return ni;
        }
    }
}