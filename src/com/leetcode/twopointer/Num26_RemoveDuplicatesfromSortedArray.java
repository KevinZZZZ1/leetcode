package com.leetcode.twopointer;

// 给定一个已排序的数组nums，删除数组中相同的元素，返回其中不同元素的个数，要求空间复杂度为O(1)
public class Num26_RemoveDuplicatesfromSortedArray {
    // 思路是：使用双指针法，cur表示当前不同的元素应该放置的位置，[i,j)表示相同元素的区间
    // 当nums[j]和nums[i]不相等时，将nums[j]赋值给nums[cur]，然后将j赋值给i，j等于i+1
    // 否则j++
    public int removeDuplicates(int[] nums) {
        int cur=1;
        int i = 0;
        int j = i+1;
        while(j<nums.length){
            if(nums[i]!=nums[j]){
                nums[cur] = nums[j];
                cur++;
                i=j;
                j=i+1;
            }else {
                j++;
            }
        }
        return cur;
    }


    public static void main(String[] args) {

    }

}
