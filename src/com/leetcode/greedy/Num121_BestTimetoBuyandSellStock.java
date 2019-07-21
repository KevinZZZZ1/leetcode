package com.leetcode.greedy;

// 给定一个数组prices，prices[i]表示第i天股票的价格，一次股票交易包含买入和卖出，只进行一次交易，求最大收益
// Input: [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//             Not 7-1 = 6, as selling price needs to be larger than buying price.
public class Num121_BestTimetoBuyandSellStock {
    // 首先要注意，这里求最大利润并不是求元素间绝对值差最大，因为股票需要先买进再卖出
    // 所以当决定买进后，就只需要和后面的元素比较大小，无需管前面的
    // 思路是，使用一个变量soFarMin记录当前最小的买入价格，用变量max记录当前价格的最大值，遍历数组
    // 比较soFarMin和当前元素的值大小prices[i]，如果prices[i]更小，则将prices[i]赋值给soFarMin
    // 否则取max和prices[i]-soFarMin的最大值；
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;

        int soFarMin = prices[0], max=0;

        for(int i=1; i<prices.length; i++){
            if(prices[i]<soFarMin)
                soFarMin = prices[i];
            else
                max = Math.max(max, prices[i]-soFarMin);
        }

        return max;
    }

    public static void main(String[] args) {

    }

}
