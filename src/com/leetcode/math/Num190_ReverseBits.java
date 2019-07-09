package com.leetcode.math;

// 给定一个无符号的32位整数，将这个整数的比特位翻转
// 比如：1101->1011
public class Num190_ReverseBits {
    // 思路是：对n进行32次循环，设置一个ret每次进行一次左移操作，并进行&1操作
    public int reverseBits(int n) {
        int ret=0;
        for(int i=0; i<32; i++){
            ret <<= 1;
            ret |= (n & 1);
            n >>>= 1;
        }
        return ret;
    }


    // 如果reverseBits被多次调用的话，该怎么样优化：可以使用一个Map进行缓存，每4位一次操作


    public static void main(String[] args) {
        int test = 43261596;
        Num190_ReverseBits n = new Num190_ReverseBits();
        n.reverseBits(test);
    }

}
