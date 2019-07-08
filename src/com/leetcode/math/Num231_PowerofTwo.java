package com.leetcode.math;

// 给定一个整数，判断该数是否为2的幂
public class Num231_PowerofTwo {
    // 思路是：2的幂以二进制表示时，只有一个 1 存在，可以使用(n&(n-1))==0这个性质来判断
    public boolean isPowerOfTwo(int n) {
        return (n>0) && ((n&(n-1))==0);
    }

}
