package com.leetcode.dp;

// 给定一个硬币集合coins，总金额amount，其中硬币个数不限制，求出coins中的硬币能组成amount的种类数
// Input: amount = 5, coins = [1, 2, 5]
// Output: 4
// Explanation: there are four ways to make up the amount:
// 5=5
// 5=2+2+1
// 5=2+1+1+1
// 5=1+1+1+1+1

public class Num518_CoinChange2 {

    public int change(int amount, int[] coins) {

        if(amount==0)
            return 1;

        if (coins==null || coins.length==0)
            return 0;

        // dp[i][j]表示使用前i个硬币，能构造成金额j的方法数
        // dp[i][j] = dp[i-1][j] + dp[i-1][j-coins[i]]
        // 同时可以写成dp[j] = d[j] + dp[j-coins[i]]
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin: coins){
            for (int j = 1; j <= amount; j++) {
                if (j>=coin)
                    dp[j] = dp[j] + dp[j-coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {

    }


}
