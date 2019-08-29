package com.leetcode.dp;

// 给定一个数组prices表示股票售价，prices[i]表示第i天股票的售价，给定一个非负整数fee表示交易费用
// 能进行任意次交易，但是每次交易都要花费1的费用，找到能获得的最大利润

// Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
// Output: 8
// Explanation: The maximum profit can be achieved by:
// Buying at prices[0] = 1
// Selling at prices[3] = 8
// Buying at prices[4] = 4
// Selling at prices[5] = 9
// The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

public class Num714_BestTimetoBuyandSellStockwithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        if (prices==null || prices.length==0)
            return 0;

        // buy[i]表示prices前i个以buy操作结束的最大利益
        // sell[i]表示prices前i个以sell操作结束的最大利益
        // buy[i] = max{buy[i-1], sell[i-1]-prices[i]}
        // sell[i] = max{sell[i-1], buy[i-1]+prices[i]-fee}
        // 初始化
        int b0 = -prices[0], b1 = -prices[0];
        int s0 = 0, s1 = 0;

        for (int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s1-prices[i]);
            s0 = Math.max(s1, b1+prices[i]-fee);
            b1 = b0;
            s1 = s0;
        }

        return s0;
    }

    public static void main(String[] args) {

    }


}
