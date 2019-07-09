package com.leetcode.math;
// 给定两个整数a、b，在不使用加减号的情况下，计算a、b之和
public class Num371_SumofTwoIntegers {
    // 思路是：使用二进制加法，a ^ b 表示没有考虑进位的情况下两数的和，(a & b) << 1 就是进位
    //
    public int getSum(int a, int b) {
        if(b==0)
            return a;
        int sum = a^b;
        int carry = (a&b)<<1;
        return getSum(sum, carry);

    }

    public static void main(String[] args) {

    }
}
