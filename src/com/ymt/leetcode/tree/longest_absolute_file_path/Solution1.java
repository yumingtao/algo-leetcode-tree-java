package com.ymt.leetcode.tree.longest_absolute_file_path;

/**
 * 参考题解
 */
public class Solution1 {
    public int lengthLongestPath(String input) {
        int n = input.length();
        int index = 0;
        int[] level = new int[n + 1];
        int maxLen = 0;
        while (index < n) {
            //先判断是否是子目录或文件，每增加一个\t目录便增加一级
            int currLevel = 0;
            while (index < n && input.charAt(index) == '\t') {
                ++index;
                ++currLevel;
            }
            //判断目录或文件的路径长度
            int currLen = 0;
            boolean isFile = false;
            //但遇到\n时，当前目录或文件结束
            while (index < n && input.charAt(index) != '\n') {
                if (input.charAt(index) == '.') {
                    isFile = true;
                }
                ++currLen;
                ++index;
            }
            //当前是\n,需要向后移一步，不然会死循环
            ++index;
            if (currLevel > 0) {
                //当前目录或文件的长度为上一级目录的长度+当前目录或文件的长度+“/”的长度1
                currLen += level[currLevel - 1] + 1;
            }
            if (isFile) {
                //如果是文件，则更新结果
                maxLen = Math.max(maxLen, currLen);
            } else {
                //不是文件，更新目录层级总长度
                level[currLevel] = currLen;
            }
        }
        return maxLen;
    }
}