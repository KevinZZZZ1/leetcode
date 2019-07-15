package com.leetcode.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

// 在一个未排序的数组中找到第k大的元素
// Input: [3,2,1,5,6,4] and k = 2
// Output: 5
// 这道题一共有三种解法：排序、堆、快速选择
public class Num215_KthLargestElementinanArray {

    // 方法一：排序
    // 思路是，使用排序的方法，使得数组有序，最后只要返回数组中第nums.length-k个元素即可
//    public int findKthLargest(int[] nums, int k){
//
//        Arrays.sort(nums);
//
//        return nums[nums.length-k];
//    }

    // 方法二：使用优先级队列实现一个最小堆，根据最小堆的性质：堆顶元素小于等于堆中其他元素，
    // 假设堆中共有k个元素，那么说堆顶是最小元素也就是说堆顶元素是第k大的元素！！这就刚好符合题目意思
    // 即我们只需要维护一个大小为k的最小堆，然后变量一遍数组，最后返回堆顶元素即可
//    public int findKthLargest(int[] nums, int k){
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//
//        for(int n: nums){
//            minHeap.add(n);
//            if(minHeap.size()>k)
//                minHeap.poll();
//        }
//        return minHeap.peek();
//    }

    // 方法三：使用快速选择的方法，partition函数能够得到start指针指向的元素在数组中排序的位置，也就是在数组中排第几；
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1, index = nums.length - k;
        while (start < end) {
            int pivot = partition(nums, start, end);
            if (pivot < index)
                start = pivot + 1;
            else if (pivot > index)
                end = pivot - 1;
            else
                return nums[pivot];
        }
        return nums[start];
    }

    // partition函数就是快速排序中的划分函数，其目的就是把数组nums划分成三个部分，即：[0, pivot)，[pivot， pivot+1)，[pivot+1, nums.length)
    // 这样返回的是pivot的所在位置，这样就可以知道pivot之前有多少元素
    // 实现划分也很简单，将start位置的元素作为划分点，
    // 如果nums[start] <= nums[pivot]，则start++;直到不满足条件
    // 然后再对end指针进行操作，如果nums[end] > nums[pivot]，则end--;
    // 如果start和end指针指向的元素都不满足条件了，则交换start和end指针指向元素的位置；
    private int partition(int[] nums, int start, int end) {
        int pivot = start, temp;
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot]) start++;
            while (start <= end && nums[end] > nums[pivot]) end--;
            if (start > end) break;
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        temp = nums[end];
        nums[end] = nums[pivot];
        nums[pivot] = temp;
        return end;
    }

    public static void main(String[] args) {

    }

}
