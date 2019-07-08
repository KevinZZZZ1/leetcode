package com.leetcode.math;

// 给定一个整数，判断该整数是否为4的幂
public class Num342_PowerofFour {
    // 思路是：如果一个树是4的幂，则其二进制表示时，奇数位置上为1
    public boolean isPowerOfFour(int num) {
        return (num>0) && (num&0b01010101010101010101010101010101) != 0;
    }

}
