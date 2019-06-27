package com.leetcode.hashmap;

// We define a harmounious array as an array where the difference between its maximum value and its minimum value is exactly 1.

// 给定一个整形数组，在数组可能的子序列（不一定是连续元素）中找到最长的和谐序列的长度，
// 和谐序列是指，序列中最大数和最小数的差正好是1

// Input: [1,3,2,2,5,2,3,7]
// Output: 5
// Explanation: The longest harmonious subsequence is [3,2,2,2,3].


import java.util.HashMap;
import java.util.Map;

public class Num594_LongestHarmoniousSubsequence {

    // 思路是：使用一个Map存储各个元素的出现次数，遍历数组中的每个元素，判断以每个元素开始的和谐序列的长度，求出最长的
    public int findLHS(int[] nums) {
        Map<Integer, Integer> countForNum = new HashMap<>();

        for(int num: nums){
            countForNum.put(num, countForNum.getOrDefault(num,0)+1);
        }
        int longest=0;
        for(int num: countForNum.keySet()){
            if(countForNum.containsKey(num+1)){
                longest = Math.max(longest, countForNum.get(num)+countForNum.get(num+1));
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] test = {1,3,2,2,5,2,3,7};

        Num594_LongestHarmoniousSubsequence n = new Num594_LongestHarmoniousSubsequence();

        n.findLHS(test);

    }

}
