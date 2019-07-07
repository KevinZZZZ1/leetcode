package com.leetcode.math;

// 给定一个包含n个不同数字的数组，取自0,1,2，...，n，找到数组中缺少的数字。
public class Num268_MissingNumber {
    // 思路是：利用 x^x为0 和x^0s为x 的方法，来判断
    // a^b^a=(a^a)^b=0^b=b
    public int missingNumber(int[] nums) {
        int ret=0;
        for(int i=0; i<nums.length; i++){
            ret = nums[i]^i^ret;
        }
        // 由于数字是从0到n的，所以经过上面的处理之后，还有n没有处理，所以在下面补上
        return ret^nums.length;
    }

    public static void main(String[] args) {

    }

}
