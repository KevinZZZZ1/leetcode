package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

// 给定一个字符串s，分割字符串使得每个部分都是回文数
// Input: "aab"
// Output:
// [
//   ["aa","b"],
//   ["a","a","b"]
// ]

public class Num131_PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s==null || s.length()==0)
            return ans;

        backtracking(ans, new ArrayList<>(), s);

        return ans;
    }

    private void backtracking(List<List<String>> ans, List<String> tmp, String s) {

        if(s.length()==0){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            // 如果字符串s索引对应的[0, i]部分为回文序列，那么使用回溯法进行判断
            if (isPalindrome(s, 0, i)){
                tmp.add(s.substring(0, i+1));
                // 将之前的[0, i]部分的回文序列去掉，只留下未判断的部分；
                backtracking(ans, tmp, s.substring(i+1));
                tmp.remove(tmp.size()-1);
            }
        }

    }
    // 判断是否为回文序列
    private boolean isPalindrome(String s, int start, int end){
        while (start<end){
            if (s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Num131_PalindromePartitioning n = new Num131_PalindromePartitioning();
        String test = "aab";
        n.partition(test);

    }

}
