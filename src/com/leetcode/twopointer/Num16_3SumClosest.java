package com.leetcode.twopointer;

import java.util.Arrays;

// 给定一个数组nums和一个整数target，在nums中找出a,b,c三个数使得三个数的和最接近target，返回这三个数的和
public class Num16_3SumClosest {
    // 思路是：和15题的思路差不多，先对数组排序，然后用指针i遍历数组，且在i固定的同时使用双指针j，k处理数组的剩余部分
    // 用变量bestSum记录当前最接近target的和，对于双指针j，k来说：
    // 如果Math.abs(nums[i]+nums[j]+nums[k]-target)<Math.abs(bestSum-target),则bestSum = nums[i]+nums[j]+nums[k]
    // 再比较nums[i]+nums[j]+nums[k]和target的大小：如果大于，则k--；小于j++；等于返回target
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int bestSum = nums[0]+nums[1]+nums[2];
        for(int i=0; i<nums.length-2; i++){
            int j=i+1, k=nums.length-1;
            while (j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(Math.abs(sum-target)<Math.abs(bestSum-target))
                    bestSum = sum;

                if(sum>target){
                    k--;
                }else if(sum<target){
                    j++;
                }else {
                    return target;
                }
            }

        }
        return bestSum;
    }


    public static void main(String[] args) {

    }

}
