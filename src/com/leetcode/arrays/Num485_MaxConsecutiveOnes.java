package com.leetcode.arrays;

// Given a binary array, find the maximum number of consecutive 1s in this array.

// 给定二进制数组，找到此数组中连续1的最大数量。
public class Num485_MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int longest=0;
        int curlongest=0;
        for (int n: nums){
            if (n==1){
                curlongest++;
            }else {
                curlongest=0;
            }
            longest =Math.max(longest,curlongest);

        }

        return longest;
    }

    public static void main(String[] args) {

    }

}
