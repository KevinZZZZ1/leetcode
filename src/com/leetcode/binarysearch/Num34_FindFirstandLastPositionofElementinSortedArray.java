package com.leetcode.binarysearch;

// 给定一个按升序排序的数组nums，给定一个整数target，找到target在nums出现的索引起始位置和结束位置
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
public class Num34_FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target);
        int last = binarySearch(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first, Math.max(first, last)};
        }
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0, h = nums.length; // 注意 h 的初始值
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= target) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {

    }

}
