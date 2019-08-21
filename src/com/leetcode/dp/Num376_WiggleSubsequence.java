package com.leetcode.dp;
// wiggle sequence被定义为：如果序列中相邻数字的差是正负交替的；
// 例如：[1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative.
// 给定一个数组nums，找出其中最长的wiggle sequence的长度
// 使用O(n)时间复杂度求解


//Input: [1,17,5,10,13,15,10,5,16,8]
//        Output: 7
//        Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

public class Num376_WiggleSubsequence {
    // 通过例子来说明：
    // nums=[2,4,5,7,5,5,7,1,2,3]
    // 使用两个数组表示dp：
    // up[i]表示以第i个元素结尾且差为正的最长wiggle序列，up[i] = max{up[i], down[j]+1}
    // down[i]表示以第i个元素结尾且差为负的最长wiggle序列，down[i] = max{down[i], up[j]+1}
    //  up=[1,2,2,2,2,2,4,4,6,6]
    //down=[1,1,1,1,3,3,3,5,5,5]
    public int wiggleMaxLength(int[] nums) {
        if (nums==null || nums.length==0)
            return 0;

        int up=1, down=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>nums[i-1]){
                up = down+1;
            }else if(nums[i]<nums[i-1]){
                down = up+1;
            }
        }

        return Math.max(up, down);
    }

}
