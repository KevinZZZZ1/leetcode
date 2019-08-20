package com.leetcode.dp;
// 给定一个整数n，将n分成至少两个整数之和，使得这些整数的积最大
// Input: 10
// Output: 36
// Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
public class Num343_IntegerBreak {

    public int integerBreak(int n) {
        // dp[i]表示整数i对应的分割整数最大乘积
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            for (int j = 1; j <= i-1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j*dp[i-j], j*(i-j)));
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

    }

}
