package com.leetcode.math;
// Given an integer, write a function to determine if it is a power of three.

// 给定一个整数，判断是否为3的幂
public class Num326_PowerofThree {
    // 一个整数n可以写成：n=(3^m)+x，如果x==0的话，则说明n是3的幂；
    // 也就是说，如果在int范围内，只要3的最大幂能被n整除的话，则n就是3的幂
    // "(int) Math.pow(3, (int) (Math.log(Integer.MAX_VALUE) / Math.log(3.0))" returns max integer that is "power of 3
    // 即1162261467
    public boolean isPowerOfThree(int n) {
        return n>0 && (1162261467%n==0);
    }

    public static void main(String[] args) {

    }

}
