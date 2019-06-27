package com.leetcode.string;

// Given two strings s and t , write a function to determine if t is an anagram of s.


// 给定两个字符串s和t，判断两个字符串包含的字符是否完全相同
public class Num242_ValidAnagram {
    // 思路是，使用一个HashMap记录第一个字符串每个字符出现的次数，再对第二个字符串进行同样的操作，最后判断两个字符串出现的字符数量是否相同；
    // 但是由于该题字符是26个小写字母，所以可以使用一个整形数组代替，先记录第一个字符串每个字符出现的次数，在对第二个字符串进行记录时，可以使用--，代替++，最后判断数组中每个元素是否为0即可；
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        for(char c: s.toCharArray()){
            count[c-'a']++;
        }

        for(char c: t.toCharArray()){
            count[c-'a']--;
        }

        for(int i: count){
            if(i!=0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

    }

}
