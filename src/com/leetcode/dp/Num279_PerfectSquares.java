package com.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

// 给定一个正整数n，使得若干个完美平方数（例如1,4,9,16...）的和为n，求出需要的完美平方数最少的个数
// Input: n = 13
// Output: 2
// Explanation: 13 = 4 + 9.
public class Num279_PerfectSquares {
    // dp[i]表示i能被完美平方数和表示的最小个数
    public int numSquares(int n) {
        List<Integer> squareList = generateSquareList(n);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int square : squareList) {
                if (square > i) {
                    break;
                }
                min = Math.min(min, dp[i - square] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    private List<Integer> generateSquareList(int n) {
        List<Integer> squareList = new ArrayList<>();
        int diff = 3;
        int square = 1;
        while (square <= n) {
            squareList.add(square);
            square += diff;
            diff += 2;
        }
        return squareList;
    }
}
