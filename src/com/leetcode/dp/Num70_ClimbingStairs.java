package com.leetcode.dp;
// 有 N 阶楼梯，每次可以上一阶或者两阶，求有多少种上楼梯的方法
public class Num70_ClimbingStairs {
    // dp[i]表示在第i个台阶上的走法，那么dp[i]可以是由在第i-1个台阶向上走一阶得到，也可以是在第i-2个台阶向上走两阶得到
    // 根据题意dp[i]=dp[i-1] + dp[i-2]
    public int climbStairs(int n) {
        if (n<=2)
            return n;

        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++){
            dp[2] = dp[1]+dp[0];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }

        return dp[2];
    }

}
