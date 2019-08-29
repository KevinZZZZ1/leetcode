package com.leetcode.dp;

// 给定一个数组prices表示股票售价，prices[i]表示第i天股票的售价，最多只能进行2次交易，找到最大利润
// Input: [1,2,3,4,5]
// Output: 4
// Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
//              engaging multiple transactions at the same time. You must sell before buying again.


//Input: [3,3,5,0,0,3,1,4]
//        Output: 6
//        Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
//        Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Num123_BestTimetoBuyandSellStockIII {


    public int maxProfit(int[] prices) {

        if (prices==null || prices.length==0)
            return 0;

        int firstBuy=Integer.MIN_VALUE, firstSell=0;
        int secondBuy=Integer.MIN_VALUE, secondSell=0;

        for (int curPrice: prices) {
            if (firstBuy < -curPrice)
                firstBuy = -curPrice;
            if (firstSell < firstBuy+curPrice)
                firstSell = firstBuy+curPrice;
            if (secondBuy < firstSell-curPrice)
                secondBuy = firstSell-curPrice;
            if (secondSell < secondBuy+curPrice)
                secondSell = secondBuy+curPrice;
        }

        return secondSell;
    }

    public static void main(String[] args) {


    }




}
