package com.leetcode.math;
// 写一个函数，求两个整数之和，要求不得使用 +、-、*、/ 四则运算符号。
public class Add {

    public static int Add(int a, int b){
        // a ^ b 表示没有考虑进位的情况下两数的和，(a & b) << 1 就是进位。
        // a+b可以拆分为以下三步:
        // a^b表示没有考虑进位的情况下两数的和
        // (a&b)<<1表示进位
        // a^b + (a&b)<<1 即为a+b的和，而可以递归的写成Add(a^b, (a&b)<<1)
        return b==0?a:Add(a^b, (a&b)<<1);

    }
}
