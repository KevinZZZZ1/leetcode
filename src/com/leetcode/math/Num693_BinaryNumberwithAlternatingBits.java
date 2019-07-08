package com.leetcode.math;

// 判断一个数的位表示是否不会出现连续的 0 和 1
public class Num693_BinaryNumberwithAlternatingBits {

    // 思路是：对于 1010 这种位级表示的数，把它向右移动 1 位得到 101，
    // 这两个数每个位都不同，因此异或得到的结果为 1111
    public boolean hasAlternatingBits(int n) {
        int a = (n ^ (n>>1));
        return (a & (a+1)) == 0;
    }

    public static void main(String[] args) {

    }

}
