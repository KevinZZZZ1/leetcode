package com.leetcode.math;
// 给定一个非负整数num，对于每个在[0, num]之间的数i，求出每个i的二进制表示中1的个数，返回一个数组；
// Input: 5
// Output: [0,1,1,2,1,2]
public class Num338_CountingBits {
    // 思路是：使用dp的思想来解决这个问题，比如说：
    // 对于数字 6(110)，它可以看成是 4(100) 再加一个 2(10)
    // 由于i&(i-1) 的结果是 i 的二进制表示中去除中最低的那一位的1，说明：i和i&(i-1)来说，ret[i]和ret[i&(i-1)]相差1
    // 所以：ret[i] = ret[i&(i-1)] + 1;
    public int[] countBits(int num) {
        int[] ret = new int[num+1];
        for(int i=1; i<=num; i++){
            ret[i] = ret[i&(i-1)]+1;
        }

        return ret;
    }

    public static void main(String[] args) {
        int test = 5;
        Num338_CountingBits n = new Num338_CountingBits();
        n.countBits(test);

    }

}
