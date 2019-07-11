package com.leetcode.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 给定一个数组，判断其中是否存在三个数a,b,c使得a+b+c==0，找出所有这些数字，并返回（不能重复）
public class Num15_3Sum {
    // 思路是：先对数组进行排序再使用一个指针遍历数组，在该指针固定的基础上再使用双指针，分别指向数组的首尾，这里需要注意的是由于题目要求不能有重复的答案，所以要对相同的值进行处理。
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<nums.length-2; i++){
            // 数组值中相同的情况
            if(i>=1 && nums[i]==nums[i-1])
                continue;
            int j = i+1, k=nums.length-1;
            while (j<k){
                if(nums[i]+nums[j]+nums[k] == 0){
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // 数组值中相同的情况
                    while (j<k && nums[k]==nums[k-1])
                        k--;
                    while (j<k && nums[j]==nums[j+1])
                        j++;

                    j++;
                    k--;
                }else if(nums[i]+nums[j]+nums[k] > 0){
                    k--;
                }else {
                    j++;
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {

    }

}
