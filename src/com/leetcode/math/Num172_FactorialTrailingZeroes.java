package com.leetcode.math;


// Given an integer n, return the number of trailing zeroes in n!.
public class Num172_FactorialTrailingZeroes {

    // 给定整数n，要求n!的尾部0的数量
    // 尾部的 0 由 2 * 5 得来，2 的数量明显多于 5 的数量，因此只要统计有多少个 5 即可
    // 对于一个数 N，它所包含 5 的个数为：N/5 + N/5^2 + N/5^3 + ...
    public int trailingZeroes(int n) {

        return n==0? 0: n/5+trailingZeroes(n/5);

    }

    public static void main(String[] args) {

    }
}
