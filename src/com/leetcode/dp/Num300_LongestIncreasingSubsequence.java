package com.leetcode.dp;

import java.util.Arrays;

// 给定一个未排序的整型数组，找到其最长递增子序列
//Input: [10,9,2,5,3,7,101,18]
//        Output: 4
//        Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
public class Num300_LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums==null || nums.length==0)
            return 0;
        int n = nums.length;
        // dp[i]表示以nums[i]结尾的最长递增子序列的长度
        // 根据题意，对于一个递增子序列 {Si1, Si2,...,Sim}，如果 im < n 并且 Sim < Sn，此时 {Si1, Si2,..., Sim, Sn} 为一个递增子序列，递增子序列的长度增加 1
        // 于是dp[i] = max{1, dp[j]+1}
        int[] dp = new int[n];
        // 对于一个长度为 N 的序列，最长递增子序列并不一定会以 SN 为结尾，因此 dp[N] 不是序列的最长递增子序列的长度，需要遍历 dp 数组找出最大值才是所要的结果，max{ dp[i] | 1 <= i <= N} 即为所求
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j])
                    dp[i] = Math.max(1, dp[j]+1);
            }
        }
        Arrays.sort(dp);
        return dp[n-1];
    }

    public static void main(String[] args) {

    }

}
