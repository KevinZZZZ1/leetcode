package com.leetcode.string;


// Given a string s, find the longest palindromic substring in s.
// You may assume that the maximum length of s is 1000.

public class Num5_LongestPalindromicSubstring {

    private int lo;
    private int maxlen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if(len<2)
            return s;

        for(int i=0; i<len-1; i++){
            // 从s的每个字符开始同时向左右两边扩展，找到符合回文序列的字符
            findPalindrome(s, i, i); // 回文字符个数为奇数，例如aba
            findPalindrome(s, i, i+1); // 回文字符个数为偶数，例如abba
        }

        return s.substring(lo, lo+maxlen);
    }

    public void findPalindrome(String s, int i, int j){
        // i是左边界，j是右边界，表示的区间为[i, j]
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }

        if(maxlen<j-i-1){
            lo = i+1;
            maxlen = j-i-1;
        }
    }


    public static void main(String[] args) {
        String test = "ac";
        Num5_LongestPalindromicSubstring n = new Num5_LongestPalindromicSubstring();
        String ans = n.longestPalindrome(test);
        System.out.println(ans);
    }


}
