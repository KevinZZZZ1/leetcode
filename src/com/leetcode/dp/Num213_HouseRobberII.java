package com.leetcode.dp;
// 房间是一个环的，也就是说第一个房子和最后一个房子是相邻的。在这种情况下，相邻的两个房子不能一起偷，求能偷到的金额的最大值。
//Input: [1,2,3,1]
//        Output: 4
//        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//        Total amount you can rob = 1 + 3 = 4.

public class Num213_HouseRobberII {
    // dp[i]表示在数组下标为i的位置的最大抢劫量，由于不能抢劫相邻住户，而且房子组成一个环，
    // 所以我们在只能在第一个房子和最后一个房子中选择一个，
    // 所以dp[i]=max{dp[i-1], dp[i-2]+nums[i]}不变，最后结果是：max{选择第一个房子的结果, 选择最后一个房子的结果}
    public int rob(int[] nums) {
        if(nums==null)
            return 0;

        int n=nums.length;
        if(n==1)
            return nums[0];

        return Math.max(rob(nums, 0, n-2), rob(nums, 1, n-1));

    }

    private int rob(int[] nums, int start, int end) {
        int pre2=0, pre1=0;
        for(int i=start; i<=end; i++){
            int cur = Math.max(pre1, pre2+nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }


    public static void main(String[] args) {

    }

}
