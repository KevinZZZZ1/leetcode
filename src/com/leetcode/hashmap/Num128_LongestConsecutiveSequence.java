package com.leetcode.hashmap;

// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//Your algorithm should run in O(n) complexity.

// 给定一个未排序的数组，找出元素中最长连续序列
// 时间复杂度O(n)

// Input: [100, 4, 200, 1, 3, 2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

import java.util.HashSet;
import java.util.Set;

public class Num128_LongestConsecutiveSequence {
    // 思路是：使用一个set将数组中的元素存储起来，然后遍历每个元素，以该元素为首的连续序列，并求出长度

    // O(n^3)的解法
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i: nums)
            set.add(i);

        int longest=0;
        for(int i: set){
            int curNum = i;
            int curLen = 1;
            while (set.contains(curNum+1)){
                curNum++;
                curLen++;
            }

            longest = Math.max(longest, curLen);
        }

        return longest;
    }
    // O(n)时间复杂度，
    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i: nums)
            set.add(i);

        int longest=0;
        for(int i: set){

            // 虽然看上去这里像O(n^2)的时间复杂度，但是这个if判断的作用很重要，它指定了i一定是序列的开始
            // 所以整个for循环过程中，while循环只会执行n次
            if(!set.contains(i-1)) {
                int curNum = i;
                int curLen = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    curLen++;
                }
                longest = Math.max(longest, curLen);
            }

        }

        return longest;
    }


    public static void main(String[] args) {
        int[] test = {100, 4, 200, 1, 3, 2};

        Num128_LongestConsecutiveSequence n = new Num128_LongestConsecutiveSequence();
        n.longestConsecutive(test);
    }



}
