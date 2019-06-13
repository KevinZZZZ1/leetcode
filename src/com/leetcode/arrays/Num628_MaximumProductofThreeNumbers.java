package com.leetcode.arrays;

// Given an integer array, find three numbers whose product is maximum and output the maximum product.

// 给定一个整形数组，找出其中三个元素的积最大值
public class Num628_MaximumProductofThreeNumbers {
    // 求三个数积最大值，有两种情况：
    // 1.三个数都是正数：
    // 只需要求数组中最大的三个数即可；
    // 2.三个数中有两个负数：
    // 要找到正数中的最大数和负数中的最小的两个数；
    public int maximumProduct(int[] nums) {
        int max1=Integer.MIN_VALUE, max2=Integer.MIN_VALUE, max3=Integer.MIN_VALUE;
        int min1=Integer.MAX_VALUE, min2=Integer.MAX_VALUE;

        for(int n:nums){
            if(n>max1){
                max3=max2;
                max2=max1;
                max1=n;
            }else if(n>max2){
                max3=max2;
                max2=n;
            }else if(n>max3){
                max3=n;
            }


            if(n<min1){
                min2=min1;
                min1=n;
            }else if(n<min2){
                min2=n;
            }

        }

        return Math.max(max1*max2*max3, max1*min1*min2);
    }
}
