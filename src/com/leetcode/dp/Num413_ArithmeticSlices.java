package com.leetcode.dp;
// arithmetic sequence 是指：一组序列最少由3个元素构成，相邻的元素之间的差相同
// 给定一个数组A，使用一对整数(P,Q)将A划分出A[P], A[p + 1], ..., A[Q - 1], A[Q]是arithmetic sequence
// 求出A中arithmetic sequence的个数

// A = [1, 2, 3, 4]

// return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
public class Num413_ArithmeticSlices {
    // dp[i]表示以 A[i] 为结尾的等差递增子区间的个数
    public int numberOfArithmeticSlices(int[] A) {
        if (A==null || A.length==0)
            return 0;

        int n = A.length;
        // dp[i]表示以 A[i] 为结尾的等差递增子区间的个数
        int[] dp = new int[n];
        for(int i=2; i<n; i++) {
            if(A[i]-A[i-1] == A[i-1]-A[i-2])
                dp[i] = dp[i-1]+1;
        }

        // 因为递增子区间不一定以最后一个元素为结尾，可以是任意一个元素结尾，因此需要返回 dp 数组累加的结果
        int total=0;
        for(int d: dp) {
            total+=d;
        }
        return total;
    }

    public static void main(String[] args) {

    }

}
