package com.leetcode.twopointer;

// 给定一个非空字符串s，在最多可以删除其中一个字符的情况下，判断该字符串是否是回文
public class Num680_ValidPalindromeII {
    // 思路是：设置两个指针i，j指向字符串的首尾，然后比较i，j指向的字符是否相等：
    // 如果相等，则继续进行遍历
    // 如果不相等，则去掉i位置的字符或者去掉j位置的字符，再继续比较
    public boolean validPalindrome(String s) {
        for(int i=0, j=s.length()-1; i<j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                //
                return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
            }

        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j){
        while (i<j){
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }


    public static void main(String[] args) {

    }

}
