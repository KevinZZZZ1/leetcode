package com.leetcode.twopointer;

import java.util.List;

// Input:
// s = "abpcplea", d = ["ale","apple","monkey","plea"]
//
// Output:
// "apple"

// 删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串。如果有多个相同长度的结果，返回字典序的最小字符串
public class Num524_LongestWordinDictionarythroughDeleting {
    // 思路是：可以将题目所说的过程理解为，从d中遍历字符串，要求这个字符串是s的最长子串而且按字典排序在最前。
    public String findLongestWord(String s, List<String> d) {
        String longest="";
        for(String tmp: d){
            int l1 = longest.length(), l2 = tmp.length();
            if(l1>l2 || (l1==l2 && longest.compareTo(tmp)<0))
                continue;
            if(isSubstring(s, tmp))
                longest = tmp;
        }

        return longest;
    }

    private boolean isSubstring(String s, String d) {

        int i=0, j=0;
        while (i<s.length() && j<d.length()){
            if(s.charAt(i) == d.charAt(j))
                j++;
            i++;
        }
        return j==d.length();
    }


    public static void main(String[] args) {

    }


}
