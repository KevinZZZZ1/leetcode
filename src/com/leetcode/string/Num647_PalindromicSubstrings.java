package com.leetcode.string;
// Given a string, your task is to count how many palindromic substrings in this string.
//
// The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

// Input: "aaa"
// Output: 6
// Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

// 给定一个字符串，计算该字符串有多少回文子字符串
public class Num647_PalindromicSubstrings {

    private int cnt=0;
    // 对于某个字符来说，从该字符开始尝试构建回文字符串，并且记录下相应的个数，
    // 遍历整个字符串，对于所有字符都进行尝试构建回文字符串的操作
    public int countSubstrings(String s) {

        for (int i=0; i<s.length(); i++){
            extendSubstring(s, i, i); // 奇数情况
            extendSubstring(s, i, i+1); // 偶数情况
        }
        return cnt;
    }

    private void extendSubstring(String s, int start, int end){
        while (start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
            cnt++;
        }
    }


    public static void main(String[] args) {

    }

}
