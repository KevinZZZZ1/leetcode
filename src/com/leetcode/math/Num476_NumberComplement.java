package com.leetcode.math;

// 给定一个正整数，求出其补码
// 例如：The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
public class Num476_NumberComplement {
    // 思路是：因为只需要按位取反即可，而且不需要考虑数字前面的0，所以只需要将数字num异或mask，其中mask是指二进制形式和num一样长度但是全部都是1的数
    public int findComplement(int num) {

        if (num == 0)
            return 1;
        int mask = 1 << 30;
        // 不断将mask中的1右移，知道1刚好到num二进制表示1的最高位：比如对于num为101时，mask为100才停止右移
        while ((num & mask) == 0)
            mask >>= 1;
        // 将mask左移一位再减1就能得到想要的mask，如100-->1000-->111
        mask = (mask << 1) - 1;
        return num ^ mask;

    }

    public static void main(String[] args) {
        int test = 5;
        Num476_NumberComplement n = new Num476_NumberComplement();
        n.findComplement(test);
    }

}
