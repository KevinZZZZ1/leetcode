package com.leetcode.dp;

import java.util.Arrays;

// 统计从矩阵左上角到右下角的路径总数，每次只能向右或者向下移动
public class Num62_UniquePaths {
    // 思路是，dp[i][j]表示在位置(i, j)处有多少种路径数，
    // 所以dp[i][j]=dp[i-1][j]+dp[i][j-1]，在不考虑边界条件的情况下
    // 如果考虑边界条件的话:
    //  当j==0时，dp[i][j]=d[i-1][j]=1 ==》上侧
    //  当i==0时，dp[i][j]=dp[i][j-1]=1 ==》左侧
    // 所以我们可以直接初始化dp数组全为1，然后从dp[1][1]开始遍历构建dp矩阵
    public int uniquePaths(int m, int n) {
        if (m==0)
            return 0;

        int[][] dp = new int[m][n];
        for(int[] tmp: dp){
            Arrays.fill(tmp, 1);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {

    }

}
