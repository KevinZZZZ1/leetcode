package com.leetcode.greedy;

// 给定一个字符串s和字符串t，判断s是否为t的子字符串，t是一个长字符串，s是一个短字符串
// 字符串的子序列是由原始字符串形成的，通过删除一些字符（或不删除）而构成的字符串，但是字符串的相对位置不能改变
// s = "axc", t = "ahbgdc"
// Return false.
public class Num392_IsSubsequence {
    // 思路是，由于s是短字符串，应该遍历字符串s，对于s中每个字符，判断是否在t中能找到，如果能找到则继续，否则返回false
    public boolean isSubsequence(String s, String t) {
        // 记录当前在t字符串中搜索到的位置
        int index=-1;
        for (char c: s.toCharArray()){
            index = t.indexOf(c, index+1);
            if (index==-1)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

    }

}
