package com.leetcode.arrays;

// Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

import java.util.Arrays;

// 给定一个数组，将数组中每个元素替换为其他元素之积，不能使用除法，时间复杂度为O(N)
public class Num238_ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] products = new int[n];
        Arrays.fill(products, 1);
        // 从左向右扫描：此时products[i] = nums[0]*nums[1]*...*nums[i-1]
        int left=1;
        for(int i=1; i<n; i++){
            left *= nums[i-1];
            products[i] *= left;
        }
        // 从右开始扫描：此时products[i] = products[i]*(nums[n-1]*nums[n-2]*...*nums[i+1]);
        int right=1;
        for(int i=n-2; i>=0; i--){
            right *= nums[n+1];
            products[i] *= right;
        }

        return products;
    }

    public static void main(String[] args) {

    }

}
