package com.leetcode.binarysearch;
// 给定一个有序数组，其中的元素除了一个元素都出现2次，而且这些元素已排序，找到出现一次的元素
// 要求时间复杂度为O(logN)，空间复杂度为O(1)
// Input: [1,1,2,3,3,4,4,8,8]
//         Output: 2
public class Num540_SingleElementinaSortedArray {
    // 因为这道题需要在O(logN)的时间复杂度内解决，所以不能使用变量数组的方法，所以只能使用二分查找
    // 由于一个元素出现存在的数组的长度一定是奇数的
    // 令 index 为 Single Element 在数组中的位置，对于中间值m来说，
    // 如果 nums[m] == nums[m + 1]，那么 index 所在的数组位置为 [m + 2, h]，此时令 l = m + 2；
    // 如果 nums[m] != nums[m + 1]，那么 index 所在的数组位置为 [l, m]，此时令 h = m
    public static int singleNonDuplicate(int[] nums) {
        int l=0, h=nums.length-1;
        while (l<h){
            int mid = l+(h-l)/2;

            if(mid%2==1)
                mid--; // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数

            if(nums[mid]==nums[mid+1])
                l = mid+2;
            else
                h = mid;
        }
        return nums[l];
    }

    public static void main(String[] args) {
//        int[] test = {3,3,7,7,10,11,11};
        int[] test = {1,1,2,3,3,4,4,8,8};
        singleNonDuplicate(test);
    }

}
