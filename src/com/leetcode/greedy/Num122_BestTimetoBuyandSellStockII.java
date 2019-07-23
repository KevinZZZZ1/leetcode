package com.leetcode.greedy;

// 给定一个数组prices[]，prices[i]表示第i天股票的价格，可以进行多次交易，多次交易之间不能交叉进行（也就是说，在再次买入之前必须先卖出），求出最大利润
// Input: [7,1,5,3,6,4]
// Output: 7
// Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
//              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
public class Num122_BestTimetoBuyandSellStockII {
    // 其实这题的目的是，对于任意一个元素prices[i]来说，记录下当prices[i+1]>prices[i]时，所有的prices[i+1]-prices[i]之和
    // 思路是，对于对于 [a, b, c, d]，如果有 a <= b <= c <= d ，那么最大收益为 d - a。而 d - a = (d - c) + (c - b) + (b - a)
    // 那么我们只需要遍历数组prices，然后发现prices[i]<prices[i+1]的情况，就将prices[i+1]-prices[i]添加到收益中
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=0; i<prices.length-1; i++){
            if(prices[i]<prices[i+1])
                profit += (prices[i+1]-prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {

    }

}
