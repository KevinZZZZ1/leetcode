package com.leetcode.arrays;
// Given an array of size n, find the majority element.
// The majority element is the element that appears more than ⌊ n/2 ⌋ times.

// 给定一个数组大小为n，找出majority element，就是元素出现次数多余n/2次的元素；

import java.util.Arrays;

public class Num169_MajorityElement {
    // 方法一：思路很简单，先给数组排序，majority一定出现在数组中位数的位置；
    // 时间复杂度为O(N)
//    public int majorityElement(int[] nums) {
//
//        Arrays.sort(nums);
//        int n = nums.length;
//
//        return nums[n/2];
//    }

    // 方法二：使用Boyer-Moore Majority Vote Algorithm 来解决这个问题，使得时间复杂度为 O(N)
    // 思路是：既然是majority，那么将其元素个数减去非majority元素个数总和一定是大于0的，
    // 1.从数组头开始，将第一个元素记作majority，定义一个count来记录majority的个数；
    // 2.遍历数组，判断majority = (count==0)?i:majority;
    // 3.如果nums[i]==majority则count++;否则count--;

    public int majorityElement(int[] nums){
        int majority=nums[0], count=0;
        for(int i: nums){
            majority = (count==0)? i: majority;
            count = (majority==i)? count+1:count-1;
        }
        return majority;
    }




    public static void main(String[] args) {
        int[] test = {2,2,1,1,1,2,2};

        Num169_MajorityElement n = new Num169_MajorityElement();
        int ans = n.majorityElement(test);
        System.out.println(ans);
    }

}
