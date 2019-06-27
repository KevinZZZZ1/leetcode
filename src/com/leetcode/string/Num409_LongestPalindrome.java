package com.leetcode.string;

// Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
//
//This is case sensitive, for example "Aa" is not considered a palindrome here.

// 给定一个字符串，找出由这些字符串中字符组成的最长回文字符串的长度
public class Num409_LongestPalindrome {
    // 思路是，使用一个长度为256的整形数组来记录字符串中每个字符的出现次数，
    // 出现次数为偶数的字符一定可以组成回文序列；
    // 出现次数为奇数的字符可以去掉一个字符变成偶数再组成回文序列；
    // 如果最长回文字符长度小于s长度，则可以在字符串中间加一个字符；
    public int longestPalindrome(String s){
        int[] count = new int[256];

        for(char c: s.toCharArray()){
            count[c]++;
        }

        int lonest=0;
        for(int cnt: count){
            lonest += ((cnt/2)*2);
        }

        if(lonest<s.length())
            lonest++;

        return lonest;

    }

    public static void main(String[] args) {

    }

}
