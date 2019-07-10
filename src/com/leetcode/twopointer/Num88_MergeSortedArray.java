package com.leetcode.twopointer;

// 给定两个已排序的数组nums1、nums2，将nums2合并到nums1中，使得nums1有序
public class Num88_MergeSortedArray {
    // 思路是：这题就是归并排序中合并的部分，就是使用两个指针，一个指向nums1，另一个指向nums2，而且从尾开始遍历，比较指针指向的元素值的大小进行归并
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1=m-1, index2=n-1;
        int indexMerge = m+n-1;
        while(index1>=0 || index2>=0){
            if(index1<0){
                nums1[indexMerge--] = nums2[index2--];
            }else if(index2<0){
                nums1[indexMerge--] = nums1[index1--];
            }else if(nums1[index1] > nums2[index2]){
                nums1[indexMerge--] = nums1[index1--];
            }else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
    }


    public static void main(String[] args) {

    }

}
