package com.leetcode.greedy;
// 给定一个非负整数数组nums[]，其中nums[i]表示在i位置最多可以向前移动nums[i]步
// 从nums的第一个位置开始到最后一个位置，最少要跳多少步
// 输入: [2,3,1,1,4]
// 输出: 2
// 解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
public class Num45_JumpGameII {

    //思路是，使用贪心的思想，比如当前位置为i，那么nums[i]表示从i出发能到达的最远位置，
    // 所以我们下一步位置j（属于[i+1, i+nums[i]]）要找到最大的值nums[j]作为下一步位置
    // 所以从头开始遍历数组nums，用end变量表示，对于在位置i能到达的最远位置，
    // maxPos记录下一步能跳的最远位置，也就是在[i+1, end]这个区间内选择nums元素值最大的；
    // 当遍历到本次能到达的最远位置时，将maxPos赋值给end，step++进入下一次位置选择
    public static int jump(int[] nums) {

        if(nums==null || nums.length<2)
            return 0;
        // maxPos表示下一步能到达的最远位置
        // end表示在位置i时能达到的最远位置
        // steps表示跳跃的步数
        int maxPos=0, end=0, steps=0;
        for(int i=0; i<nums.length-1; i++){
            // i+nums[i]表示能到达最远的位置
            maxPos = Math.max(maxPos, i+nums[i]);
            if(i==end){
                end = maxPos;
                steps++;
            }
        }

        return steps;
    }

    public static void main(String[] args) {
        int[] test = {2,3,1,1,4};
        jump(test);
    }

}
