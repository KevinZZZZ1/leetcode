package com.leetcode.dp;
// 抢劫一排住户，但是不能抢邻近的住户，求最大抢劫量
//Input: [2,7,9,3,1]
//        Output: 12
//        Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//        Total amount you can rob = 2 + 9 + 1 = 12.

public class Num198_HouseRobber {
    // dp[i]表示在数组下标为i的位置的最大抢劫量，由于不能抢相邻的住户，
    // 所以dp[i] = max{dp[i-1], dp[i-2]+nums[i]}
    public int rob(int[] nums) {

        if (nums==null || nums.length==0)
            return 0;

        int n = nums.length;
        int[] dp = new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }


}
