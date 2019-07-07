package com.leetcode.math;
// 给定一个非空的整数数组，除了一个元素外，每个元素都会出现两次，找出出现一次的元素。
public class Num136_SingleNumber {
    // 思路是：利用 x^x为0 和x^0s为x 的方法，来判断
    // a^b^a=(a^a)^b=0^b=b
    public int singleNumber(int[] nums) {
        int ret=0;
        for(int n: nums)
            ret = ret^n;
        return ret;
    }


    public static void main(String[] args) {

    }

}
