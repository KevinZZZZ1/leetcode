package com.leetcode.dp;
// 给定一个矩阵grid，求从矩阵的左上角到右下角的最小路径和，每次只能向右和向下移动。

// Input:
// [
//   [1,3,1],
//   [1,5,1],
//   [4,2,1]
// ]
// Output: 7
// Explanation: Because the path 1→3→1→1→1 minimizes the sum.
public class Num64_MinimumPathSum {
    // dp[i][j]表示，在位置(i, j)处最小路径和，
    // 那么dp[i][j]可以写成：dp[i][j] = min{dp[i][j-1]+grid[i][j], dp[i-1][j]+grid[i][j]}, 不考虑边界条件的情况下
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0)
            return 0;

        int m=grid.length, n=grid[0].length;
        int[][] dp = new int[m+1][n];

        for (int i=1; i<=m; i++){
            for (int j = 0; j < n; j++) {
                if (j==0){
                    dp[i][j] = dp[i-1][j]; // 边界条件：j==0,即只能是从左侧走过来的
                }else if (i==1){
                    dp[i][j] = dp[i][j-1]; // 边界条件：i==0，即只能是从上侧走过来的
                }else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]);
                }

                dp[i][j] += grid[i-1][j];
            }
        }

        return dp[m][n-1];
    }

    public static void main(String[] args) {

    }

}
