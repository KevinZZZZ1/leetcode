package com.leetcode.arrays;

// Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
// prove that at least one duplicate number must exist.
// Assume that there is only one duplicate number, find the duplicate one.

// 给定包含n + 1个整数的数组nums，其中每个整数在1和n之间（包括1和n），
// 假设只有一个重复的数字，找到重复的数字。
public class Num287_FindtheDuplicateNumber {
    // 思路是：可以使用通过交换数组元素，使得数组上的元素在正确的位置上的方法求解，最后那个不满足条件的就是多余元素
    public int findDuplicate(int[] nums){
        int ans=0;

        for (int i = 0; i <nums.length ; i++) {
            while(nums[i]!=i+1 && nums[nums[i]-1]!=nums[i])
                swap(nums, i, nums[i]-1);
        }

        for(int i=0; i<nums.length; i++){
            if (nums[i]!=i+1)
                ans = nums[i];
        }

        return ans;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

    }

}
