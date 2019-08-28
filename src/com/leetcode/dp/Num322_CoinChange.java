package com.leetcode.dp;
// 给定一个硬币集合coins，钱的总数amount，找到使用最少的硬币得到与amount相同的钱
// 如果无法表示，则返回-1

import java.util.Arrays;

// Input: coins = [1, 2, 5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
public class Num322_CoinChange {
    // 因为硬币可以重复使用，因此这是一个完全背包问题。完全背包只需要将 0-1 背包的逆序遍历 dp 数组改为正序遍历即可。
    public int coinChange(int[] coins, int amount) {
        if (coins==null || coins.length==0 || amount==0)
            return 0;

        // dp[i][j]表示使用前i个硬币能表示j的最小硬币数
        // dp[i][j] = min{dp[i-1][j], dp[i-1][j-coins[i]]+1}
        // 所以可以写成:dp[j] = min{dp[j], dp[j-coins[i]]+1}
        int[] dp = new int[amount+1];
        int max = amount+1;
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = 1; j <= amount; j++) {
                if (coin<=j)
                    dp[j] = Math.min(dp[j], dp[j-coin]+1);

            }
        }

        return dp[amount]>amount? -1: dp[amount];
    }

    public static void main(String[] args) {

    }

}
