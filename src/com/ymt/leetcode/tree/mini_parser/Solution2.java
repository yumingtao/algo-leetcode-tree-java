package com.ymt.leetcode.tree.mini_parser;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    public NestedInteger deserialize(String s) {
        if(s.charAt(0) != '['){
            return new NestedInteger(Integer.parseInt(s));
        }
        char ch;
        int start = 0;
        Deque<NestedInteger> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); ++i){
            ch = s.charAt(i);
            if(Character.isDigit(ch) || ch == '-'){
                continue;
            }else{
                if(ch == '['){
                    stack.push(new NestedInteger());
                }else{
                    char startCh = s.charAt(start);
                    if(Character.isDigit(startCh) || startCh == '-'){
                        stack.peek().add(new NestedInteger(Integer.parseInt(s.substring(start, i))));
                    }
                    if(ch == ']' && stack.size() > 1){
                        NestedInteger ni = stack.pop();
                        stack.peek().add(ni);
                    }
                }
                start = i + 1;
            }
        }
        return stack.pop();
    }
}