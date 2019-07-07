package com.leetcode.math;
// 两个整数之间的汉明距离是相应位不同的位置数，给定两个整数x和y，计算汉明距离
public class Num461_HammingDistance {

    // 思路是：对两个数进行异或操作，位级表示不同的那一位为 1，统计有多少个 1 即可
    public int hammingDistance(int x, int y) {
        int z = x^y;
        int cnt=0;
        while(z!=0){

            z = z&(z-1); // z&(z-1)得到二进制数中，去掉最后低位1的值
            cnt++;
        }
        return cnt;
        //return Integer.bitCount(x^y);
    }

    public static void main(String[] args) {

    }

}
