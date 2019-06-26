package com.leetcode.stackandqueue;
// Given a circular array (the next element of the last element is the first element of the array),
// print the Next Greater Number for every element.
// The Next Greater Number of a number x is the first greater number to its traversing-order next in the array,
// which means you could search circularly to find its next greater number.
// If it doesn't exist, output -1 for this number.


// Input: [1,2,1]
// Output: [2,-1,2]
// Explanation: The first 1's next greater number is 2;
// The number 2 can't find next greater number;
// The second 1's next greater number needs to search circularly, which is also 2.


import java.util.Arrays;
import java.util.Stack;

// 给定一个循环数组，即最后一个元素的下一个元素是第一个元素，找出循环数组中比当前元素大的第一个元素
public class Num503_NextGreaterElementII {
    // 思路是：由于是个循环数组，所以查找时的范围是两倍的数组长度，用栈记录下前一个元素的位置
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> preIndex = new Stack<>();
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        for (int i=0; i<n*2; i++){
            int tmp = nums[i%n];
            while(!preIndex.isEmpty() && tmp>nums[preIndex.peek()]){
                ret[preIndex.pop()] = tmp;
            }
            if(i<n)
                preIndex.push(i);

        }
        return ret;
    }

    public static void main(String[] args) {
        int[] test = {1,2,1};
        Num503_NextGreaterElementII n =new Num503_NextGreaterElementII();

        n.nextGreaterElements(test);

    }

}
