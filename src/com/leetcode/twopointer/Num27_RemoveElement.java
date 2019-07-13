package com.leetcode.twopointer;


// 给定一个数组nums和一个值val，移除数组中值等于val的元素，并且返回移除后数组的长度，要求空间复杂度为O(1)
public class Num27_RemoveElement {

    // 思路是：和26题的思路差不多，也是使用双指针i，n，i指向数组首部，n指向数组尾部，使用指针i遍历数组，
    // 如果nums[i]==val的话，将尾部的值复制过来（就算是值等于val也无所谓，因为还是符合nums[i]==val的条件，直到该条件不成立），
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
