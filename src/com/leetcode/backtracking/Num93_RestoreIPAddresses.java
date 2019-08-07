package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

// 给定一个字符串只包含数字，求出该字符串能构成的所有IP地址
// Given "25525511135",
// return ["255.255.11.135", "255.255.111.35"].
public class Num93_RestoreIPAddresses {
    // 思路是，
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if(s==null || s.length()==0)
            return ans;

        backtracing(ans, s, 0, new StringBuilder());

        return ans;
    }

    private void backtracing(List<String> ans, String s, int k, StringBuilder sb) {
        // 已满足IP地址4部分组成要求，或者s为""
        if(k==4 || s.length()==0){
            // 两个条件同时满足的就是答案
            if(k==4 && s.length()==0){
                ans.add(sb.toString());
            }
            return;
        }
        // 遍历字符串s中的每个字符，尝试将字符加入到当前正在处理IP地址的结果集tempAddress中
        for(int i=0; i<s.length() && i<=2; i++){
            if(i!=0 && s.charAt(0)=='0')
                break;
            // 正在处理的字符
            String part = s.substring(0, i+1);
            if(Integer.valueOf(part)<=255){
                if(sb.length()>0){
                    part = "."+part;
                }
                // 将字符串part添加到结果集中
                sb.append(part);
                // 进行下一次搜索
                backtracing(ans, s.substring(i+1), k+1, sb);
                // 将字符串part从正在处理的结果集中删除
                sb.delete(sb.length()-part.length(), sb.length());
            }

        }

    }

    public static void main(String[] args) {

    }

}
