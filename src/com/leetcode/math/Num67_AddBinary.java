package com.leetcode.math;

// Given two binary strings, return their sum (also a binary string).
//The input strings are both non-empty and contains only characters 1 or 0.

public class Num67_AddBinary {
    // 二进制的加法是从最低位到最高位
    // 某位的数字：(a[i]+b[i]+carry)%2
    // 进位：(a[i]+b[i]+carry)/2
    public static String addBinary(String a, String b) {
        // 从最低位开始，即a.length()-1, b.length()-1
        int i=a.length()-1, j=b.length()-1, carry=0;
        StringBuilder sb = new StringBuilder();
        while(carry==1 || i>=0 || j>=0){
            if(i>=0 && a.charAt(i--)=='1'){
                carry++; // 相当于carry = carry+1;即a[i]==1的情况
            }
            if(j>=0 && b.charAt(j--)=='1'){
                carry++;
            }
            sb.append(carry%2);
            carry/=2;
        }
        // 最低位在前，所以要reverse一下
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
//        String a = "11", b = "1";
        String a = "1010", b = "1011";
        String ans = addBinary(a,b);
        System.out.println(ans);
    }

}
