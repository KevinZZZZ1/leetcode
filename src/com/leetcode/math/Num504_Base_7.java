package com.leetcode.math;



// Given an integer, return its base 7 string representation.
public class Num504_Base_7 {
    public static String convertToBase7(int num) {
        if(num==0)
            return "0";
        boolean isNegative = num<0;
        num = Math.abs(num);
        StringBuffer sb = new StringBuffer();
        while (num>0){
            sb.append(num%7);
            num = num/7;
        }
        if(isNegative)
            sb.append("-");

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int test = -7;
        System.out.println(convertToBase7(test));
    }

}
