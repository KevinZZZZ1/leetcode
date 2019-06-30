package com.leetcode.arrays;
// Given an array nums,
// write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// 给定一个数组，在保持数组元素非零值相对顺序的情况下，将数组中零元素移动到数组尾部
public class Num283_MoveZeroes {
    // 思路是：在遍历数组的同时，就将非零元素值移动到相应的位置，最后再补齐上0即可；
    public void moveZeroes(int[] nums) {
        int idx = 0; //记录下一个非零值应该移动的索引位置

        for(int n: nums){
            if (n!=0)
                nums[idx++]=n;
        }

        while(idx<nums.length){
            nums[idx++] = 0;
        }
    }



    public static void main(String[] args) {
        int[] test = {0,1,0,3,12};
        Num283_MoveZeroes n = new Num283_MoveZeroes();
        n.moveZeroes(test);

    }

}
