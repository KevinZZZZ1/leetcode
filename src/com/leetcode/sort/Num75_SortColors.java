package com.leetcode.sort;

// 有三种颜色的球，算法的目标是将这三种球按颜色顺序正确地排列。
// 它其实是三向切分快速排序的一种变种，在三向切分快速排序中，每次切分都将数组分成三个区间：小于切分元素、等于切分元素、大于切分元素，而该算法是将数组分成三个区间：等于红色、等于白色、等于蓝色
public class Num75_SortColors {

    // 将数组空间分成4部分，[0, zero]只有0元素，[zero+1, one-1]只有1元素，[one, two-1]表示为排序部分，[two, nums.length-1]只有2元素
    // 而且使用指针one来遍历数组，nums[one]表示当前处理的元素
    public void sortColors(int[] nums) {
        int zero=-1, one=0, two=nums.length;
        while (one<two){
            if (nums[one] == 0) {
                swap(nums, ++zero, one++);
            } else if (nums[one] == 2) {
                swap(nums, --two, one);
            } else {
                ++one;
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {

    }

}
