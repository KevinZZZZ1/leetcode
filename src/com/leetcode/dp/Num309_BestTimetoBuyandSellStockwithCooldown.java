package com.leetcode.dp;

// 给定一个数组prices表示股票的出售价格，prices[i]表示第i天的股票出售价格
// 找到最大利润，可以进行任意次交易，交易规则是：
//      在买入该股票前必须先卖出
//      卖出股票后有一天的冷却期，即卖出的下一天不能买入

// Input: [1,2,3,0,2]
// Output: 3
// Explanation: transactions = [buy, sell, cooldown, buy, sell]

public class Num309_BestTimetoBuyandSellStockwithCooldown {

    public int maxProfit(int[] prices) {
        if (prices==null || prices.length==0)
            return 0;

        // buy[i]表示prices前i个以buy操作结束的最大利益
        // sell[i]表示prices前i个以sell操作结束的最大利益
        // buy[i] = max{buy[i-1](第i天不买入), sell[i-2]-prices[i](第i天买入，即买入prices[i]，所以要在i-2天的情况上买入)}
        // sell[i] = max{sell[i-1](第i天不卖出), buy[i-1]+prices[i]}
        // 可以用b2,b1,b0表示buy[i-2],buy[i-1],buy[i];s2,s1,s0表示sell[i-2],sell[i-1],sell[i]

        // 初始化
        int b0 = -prices[0], b1 = -prices[0];
        int s0 = 0, s1 = 0, s2 = 0;

        for (int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        // 最后肯定是以sell操作结尾的，所以返回s0就行
        return s0;
    }

    public static void main(String[] args) {

    }


}
