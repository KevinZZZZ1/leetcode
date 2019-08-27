package com.leetcode.dp;

import java.util.Map;

// 给定m个0，n个1以及一个字符串数组strs，，每个0和1只能使用一次，使用给定的m个0和n个1，能组成strs中最多的字符串个数
// Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
//Output: 4
//
//Explanation: There are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are "10","0001","1","0"
public class Num474_OnesandZeroes {
    // 这是一个多维费用的 0-1 背包问题，有两个背包大小，0 的数量和 1 的数量
    public int findMaxForm(String[] strs, int m, int n) {

        if (strs==null || strs.length==0 || (m==0 && n==0))
            return 0;

        // dp[i][j]表示i个0，j个1最大能表示strs中的字符串个数
        // 所以dp[i][j]=max{dp[i][j](该字符串不能表示), dp[i-zeros][j-ones]+1(该字符串能表示)}
        int[][] dp = new int[m+1][n+1];

        for (String s: strs) {
            int zeros = 0;
            int ones = 0;
            for (char c: s.toCharArray()){
                if (c=='0')
                    zeros++;
                else
                    ones++;
            }

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones]+1);
                }
            }

        }
        return dp[m][n];


    }

    public static void main(String[] args) {



    }

}
