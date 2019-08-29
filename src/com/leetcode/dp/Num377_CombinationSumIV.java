package com.leetcode.dp;

// 给定一个不重复全是整数的数组nums，一个整数target，可以使用nums元素无限次，列出所有使得元素和为target的组合次数

// nums = [1, 2, 3]
// target = 4

// The possible combination ways are:
// (1, 1, 1, 1)
// (1, 1, 2)
// (1, 2, 1)
// (1, 3)
// (2, 1, 1)
// (2, 2)
// (3, 1)

// Note that different sequences are counted as different combinations.

// Therefore the output is 7.


import java.util.Arrays;

public class Num377_CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        if (nums==null || nums.length==0 || target==0)
            return 0;

        // dp[i][j]表示使用nums中前i个元素的组合之和为j的所有可能情况
        // dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]]
        // dp[j] = dp[j] + dp[j-nums[i]]
        int[] dp = new int[target+1];
        dp[0] = 1;
        Arrays.sort(nums);
        // for (int num: nums){
        //     for (int j = 1; j <= target; j++) {
        //         if (j>=num)
        //             dp[j] = dp[j] + dp[j-num];
        //     }
        // }

        for (int j = 1; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if(j>=nums[i])
                    dp[j] = dp[j] + dp[j - nums[i]];
            }
        }

        return dp[target];

    }

    public static void main(String[] args) {

    }

}
