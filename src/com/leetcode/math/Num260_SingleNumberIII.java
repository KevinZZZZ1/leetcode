package com.leetcode.math;

// 给定一个数组，数组中除了两个元素出现一次之外，其他元素都出现两次，找出只出现一次的元素
public class Num260_SingleNumberIII {
    // 思路是：根据a^a=0，这一特性先得到这两个自出现一次的数异或的值，
    // 在根据a&(-a)得到a二进制表示的最低位的1构成的数字，如：对于二进制表示 10110100，-n 得到 01001100，相与得到 00000100
    public int[] singleNumber(int[] nums) {
        int tmp=0;
        for(int n: nums){
            tmp = tmp ^n;
        }

        tmp &= (-tmp);
        int[] ret = new int[2];

        for(int n: nums){
            if((n&tmp)==1)
                ret[0] ^= n;
            else
                ret[1] ^= n;
        }
        return ret;
    }


    public static void main(String[] args) {

    }


}
