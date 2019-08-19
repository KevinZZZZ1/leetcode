package com.leetcode.dp;
// 求区间 i ~ j 的和，可以转换为 sum[j + 1] - sum[i]，其中 sum[i] 为 0 ~ i - 1 的和
// Given nums = [-2, 0, 3, -5, 2, -1]
//
//sumRange(0, 2) -> 1
//sumRange(2, 5) -> -1
//sumRange(0, 5) -> -3
public class Num303_RangeSumQuery_Immutable {

    // dp[i]表示在位置i处nums数组的和
    private int[] dp;

    public Num303_RangeSumQuery_Immutable(int[] nums) {
        dp = new int[nums.length+1];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i-1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j+1] - dp[i];
    }

    public static void main(String[] args) {

    }

}
