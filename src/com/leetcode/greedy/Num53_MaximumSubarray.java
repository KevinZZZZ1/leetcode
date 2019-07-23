package com.leetcode.greedy;

// 给定一个整数数组nums，在其中找到一个连续的子数组使得该子数组的元素和最大并且返回该和
// Input: [-2,1,-3,4,-1,2,1,-5,4],
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.
public class Num53_MaximumSubarray {
    // 这个问题其实是一个DP问题，我们用dp[i]表示以在i位置元素结尾的元素之和，那么dp[i] = Max(dp[i-1]+nums[i], dp[i-1])，由于dp[i]只是依赖于dp[i-1]所以可以用preSum来记录上一个子数组元素之和
    // 思路是，使用maxSum记录所有子数组和的最大值，preSum记录前一个当前子数组的和
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        int preSum = nums[0];
        int maxSum = preSum;

        for (int i = 1; i < nums.length; i++) {
            preSum = preSum>0? preSum+nums[i]: nums[i];
            maxSum = Math.max(maxSum, preSum);
        }

        return maxSum;
    }


    public static void main(String[] args) {

    }

}
