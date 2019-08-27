package com.leetcode.dp;
// 给定一个整型非负数组nums，一个整数S，对于nums中每个元素选择在其前面加上-或+，使得它们的和为S

//Input: nums is [1, 1, 1, 1, 1], S is 3.
//        Output: 5
//        Explanation:
//
//        -1+1+1+1+1 = 3
//        +1-1+1+1+1 = 3
//        +1+1-1+1+1 = 3
//        +1+1+1-1+1 = 3
//        +1+1+1+1-1 = 3
//
//        There are 5 ways to assign symbols to make the sum of nums be target 3.

import java.util.Arrays;

public class Num494_TargetSum {
    // 该问题可以转化为第416题，从而使用0-1背包的方法求解
    // 可以将这组数看成两部分：P和N，其中P使用正号，N使用负号
    // 可以将这组数看成两部分，P 和 N，其中 P 使用正号，N 使用负号，有以下推导：
    //
    //                  sum(P) - sum(N) = target
    //sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
    //                       2 * sum(P) = target + sum(nums)
    //因此只要找到一个子集，令它们都取正号，并且和等于 (target + sum(nums))/2，就证明存在解。
    public int findTargetSumWays(int[] nums, int S) {
        if (nums==null || nums.length==0)
            return 0;

        int sum = computeArraySum(nums);
        if (sum<S || (S+sum)%2==1)
            return 0;
        // 计算nums中0的个数
//        int numZeros = 0;
//        for (int tmp: nums){
//            if (tmp==0)
//                numZeros++;
//        }


        int W = (S+sum)/2;
        int n = nums.length;
        // dp[i][j]表示前i个元素能表示整数j有多少种方法
        int[][] dp = new int[n+1][W+1];
        // 初始化dp矩阵
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

       for (int i = 1; i <= n; i++) {
            for (int j = 1; j<= W; j++) {

                if(j>=nums[i-1]) {
                    // 能放下nums[i-1]，然后选还是不选
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }else {
                    // 不能放下nums[i-1]，只能不选
                    dp[i][j] = dp[i-1][j];
                }

            }
        }

        return dp[n][W];
    }

//    public int findTargetSumWays(int[] nums, int S) {
//        int sum = computeArraySum(nums);
//        if (sum < S || (sum + S) % 2 == 1) {
//            return 0;
//        }
//        int W = (sum + S) / 2;
//        int[] dp = new int[W + 1];
//        dp[0] = 1;
//        for (int num : nums) {
//            for (int i = W; i >= num; i--) {
//                dp[i] = dp[i] + dp[i - num];
//            }
//        }
//        return dp[W];
//    }


    private int computeArraySum(int[] nums) {
        int sum=0;
        for (int tmp: nums){
            sum += tmp;
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] test = {1,2,1};
        Num494_TargetSum n = new Num494_TargetSum();
        n.findTargetSumWays(test, 0);


    }

}
