package com.leetcode.dp;

// 给定两个字符串，求解这两个字符串的最长公共子序列（Longest Common Sequence）。
// 比如字符串1：BDCABA；字符串2：ABCBDAB
//则这两个字符串的最长公共子序列长度为4，最长公共子序列是：BCBA


public class LCS {
//     这道题可以使用dp来做，用S1表示字符串1，S2表示字符串2，dp[i][j]表示S1的前i个字符与S2的前j个字符最长公共子序列的长度
//     于是根据题意有：
//                    如果S1[i]==S2[j]的话，dp[i][j] = dp[i-1][j-1]+1;
//                    如果S1[i]!=S2[j]的话，dp[i][j] = max{dp[i-1][j], dp[i][j-1]}
    public int lengthOfLCS(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }

}
