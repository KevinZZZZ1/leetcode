package com.leetcode.twopointer;


// 给定一个数组nums和一个值val，移除数组中值等于val的元素，并且返回移除后数组的长度，要求空间复杂度为O(1)
public class Num27_RemoveElement {

    //
    public int removeElement(int[] nums, int val) {
        int i=0;
        int n=nums.length-1;
        while(i<=n){
            if(nums[i] == val){
                nums[i] = nums[n];
                n--;
            }else{
                i++;
            }
        }

        return n+1;
    }

    public static void main(String[] args) {

    }

}
