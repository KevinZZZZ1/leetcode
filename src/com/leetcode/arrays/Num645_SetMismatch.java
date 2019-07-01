package com.leetcode.arrays;
// Input: nums = [1,2,2,4]
// Output: [2,3]

// 一个数组元素在 [1, n] 之间，其中一个数被替换为另一个数，找出重复的数和丢失的数
public class Num645_SetMismatch {
    // 思路是：最简单的思路就是对数组排序，然后在进行遍历，这样就能得到结果，但是这样的时间复杂度为O(nlogn)
    // 可以使用时间复杂度为O(n)，空间复杂度为O(1)的方法求解，即通过交换数组元素，使得数组上的元素在正确的位置上
    public int[] findErrorNums(int[] nums) {
        for (int i=0; i<nums.length; i++){
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return null;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

    }

}
