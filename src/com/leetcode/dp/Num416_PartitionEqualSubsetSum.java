package com.leetcode.dp;

// 给定一个非空只包含正数的数组，判断该数组是否能分成两部分，使得这两部分的和相等

//Input: [1, 5, 11, 5]
//
//        Output: true
//
//        Explanation: The array can be partitioned as [1, 5, 5] and [11].

import com.xiecheng.Num2;

import java.util.Arrays;

public class Num416_PartitionEqualSubsetSum {
    // 可以看成一个背包大小为sum/2的0-1背包问题
    // dp[i][j]表示前i个元素中是否能表示出j
    public boolean canPartition(int[] nums) {
        if (nums==null || nums.length==0)
            return false;

        int sum = computeArraySum(nums);
        if (sum%2 != 0)
            return false;
        int m = sum/2;
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][m+1];

        // 对dp矩阵进行初始处理，让左边界的值都变成true
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }
        dp[0][0] = true;
        for (int i=1; i<=n; i++){
            dp[i][0] = true;
        }
        for (int i=1; i<=m; i++) {
            dp[0][m] = false;
        }

        // 开始进行dp
        // 对于在i位置的数nums[i]来说，如果选择nums[i]，那么dp[i][j] = dp[i-1][j-nums[i]]，该结果依赖于前i-1个元素能否表示出j-nums[i]
        //                             如果不选择nums[i]，那么dp[i][j] = dp[i-1][j]
        // 所以：dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }
        return dp[n][m];
    }


    private int computeArraySum(int[] nums) {
        int sum=0;
        for (int tmp: nums)
            sum+=tmp;
        return sum;

    }


    public static void main(String[] args) {
        int[] test = {1,5,11,5};
        Num416_PartitionEqualSubsetSum n = new Num416_PartitionEqualSubsetSum();
        n.canPartition(test);
    }

}
