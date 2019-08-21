package com.leetcode.dp;
// 对于 (a, b) 和 (c, d) ，如果 b < c，则它们可以构成一条链。
//Input: [[1,2], [2,3], [3,4]]
//        Output: 2
//        Explanation: The longest chain is [1,2] -> [3,4]

import java.util.Arrays;

public class Num646_MaximumLengthofPairChain {
    // dp[i][j]表示以元素pairs[i][j]结尾的最长链的区间个数
    // 如果当前处理的区间的左边值大于已知链的右边值，那么就能把当前处理区间加入已知链中
    // 所以有：dp[i][j] = max{dp[i-1][j]+1, 1}
    // 最后要求的是所有链中最长的，所以要在dp数组中找到最大值
    public static int findLongestChain(int[][] pairs) {
        if (pairs==null || pairs.length==0)
            return 0;
        int m=pairs.length;
        int[] dp = new int[m];
        // 先按照区间左边值排序
        Arrays.sort(pairs, (a, b)->(a[0]-b[0]));
        Arrays.fill(dp, 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1]<pairs[i][0]){
                    dp[i] = Math.max(1, dp[j]+1);
                }
            }
        }

        Arrays.sort(dp);
        return dp[m-1];
    }

    public static void main(String[] args) {
        int[][] test = {{1,2}, {2,3}, {3,4}};

        findLongestChain(test);
    }


}
