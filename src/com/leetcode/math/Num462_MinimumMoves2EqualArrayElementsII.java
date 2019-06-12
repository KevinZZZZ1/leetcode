package com.leetcode.math;

// Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
// You may assume the array's length is at most 10,000.

// 题目意思就是，给定一个非空整型数组，每次让数组中元素增加1或减少1，找出使得数组中每个元素都相等需要改变的最少次数

import java.util.Arrays;

public class Num462_MinimumMoves2EqualArrayElementsII {
    // 这是个典型的相遇问题，移动距离最小的方式是所有元素都移动到中位数。理由如下：
    //设 m 为中位数。a 和 b 是 m 两边的两个元素，且 b > a。要使 a 和 b 相等，它们总共移动的次数为 b - a，这个值等于 (b - m) + (m - a)，也就是把这两个数移动到中位数的移动次数。
    //设数组长度为 N，则可以找到 N/2 对 a 和 b 的组合，使它们都移动到 m 的位置。


    // 方法一，先排序再求中位数，时间复杂度O(nlogn)
//    public static int minMoves2(int[] nums) {
//        Arrays.sort(nums);
//        int count=0;
//        int low=0, high=nums.length-1;
//        while(low<=high){
//
//            count+=(nums[high]-nums[low]); //
//            low++;
//            high--;
//
//        }
//        return count;
//    }



    // 方法二：快速寻找中位数，时间复杂度O(n)
    public int minMoves2(int[] nums){
        int count=0;
        int median = findKthSmallest(nums, nums.length / 2);
        for(int n:nums){
            count+=Math.abs(n-median);
        }
        return count;
    }


    // 在数组中找到第k小的数
    private int findKthSmallest(int[] nums, int k){
        int l=0, h=nums.length-1;
        while(l<h){
            int tmp = partition(nums, l, h);
            if(k==tmp)
                break;
            if(tmp<k)
                l=tmp+1;
            if(tmp>k)
                h=tmp-1;
        }
        return nums[k];
    }

    private int partition(int[] nums, int l, int h){
        int i=l, j=h+1;
        while (true){
            // nums[l]作为key
            while (nums[++i]<nums[l] && i<h);
            while (nums[--j]>nums[l] && j>l);
            if(i>=j)
                break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] test = {1,2,3};
//        int ans = minMoves2(test);
//        System.out.println(ans);



    }

}
