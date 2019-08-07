package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

// 给定一个数字字符对应表，以及数字只包括2-9，找出所有数字能表示的所有字符
// MAP = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}
// Input: "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

public class Num17_LetterCombinationsofaPhoneNumber {
    // 思路是，从MAP中找到对应的字符串，并且从字符串中选择一个字符，然后进行回溯
    private static final String[] MAP = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits==null || digits.length()==0)
            return ans;
        backtracing(ans, digits, new StringBuilder());

        return ans;

    }

    private void backtracing(List<String> ans, String digits, StringBuilder sb) {
        if (sb.length()==digits.length()){
            ans.add(sb.toString());
            return;
        }
        // 获得当前digits中字符对应的整数值
        int index = digits.charAt(sb.length()) - '0';
        // 获得整数值对应的字符串
        String s = MAP[index];
        // 要进行回溯的是，对字符串进行处理
        for (char c: s.toCharArray()){
            sb.append(c);
            backtracing(ans, digits, sb);
            sb.deleteCharAt(sb.length()-1);
        }


    }

    public static void main(String[] args) {

    }


}
