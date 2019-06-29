package com.leetcode.string;
// Given two strings s and t, determine if they are isomorphic.
//
//Two strings are isomorphic if the characters in s can be replaced to get t.
//
//All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

// Input: s = "egg", t = "add"
// Output: true

// Input: s = "foo", t = "bar"
// Output: false

//给定两个字符串s、t，判断它们是否同构，所谓同构是指：如果s中的字符可以替换为t，则两个字符串是同构的
public class Num205_IsomorphicStrings {
    // 遍历字符串s、t，记录下字符上次出现的位置，如果两个字符上次出现的位置一样，那么就是同构的
    public boolean isIsomorphic(String s, String t) {
        // 以sPreIndex为例，说明以下这种数组的用法，该数组使用index来表示字符的种类，比如'a'对应的是97，'d'对应的是100；
        // 而sPreIndex[i]记录i对应的ASCII编码的字符出现的次数

        // 这里sPreIndex[i]用来i值对应的记录字符上一次的位置；
        int[] sPreIndex = new int[256];
        int[] tPreIndex = new int[256];

        for(int i=0; i<s.length(); i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if(sPreIndex[sc] != tPreIndex[tc])
                return false;

            sPreIndex[sc] = i+1;
            tPreIndex[tc] = i+1;

        }
        return true;
    }


    public static void main(String[] args) {
        String s = "egg";
        String t = "add";

        Num205_IsomorphicStrings n = new Num205_IsomorphicStrings();

        n.isIsomorphic(s, t);
    }

}
