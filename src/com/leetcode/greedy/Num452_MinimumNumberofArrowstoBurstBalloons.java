package com.leetcode.greedy;

// 气球在一个水平数轴上摆放，可以重叠，飞镖垂直投向坐标轴，使得路径上的气球都被刺破。求解最小的投飞镖次数使所有气球都被刺破。
// 对于points数组中的points[0][]来说，points[0][1]-points[0][0]表示第一个气球的直径
// Input:
// [[10,16], [2,8], [1,6], [7,12]]

// Output:
// 2

import java.util.Arrays;
import java.util.Comparator;

public class Num452_MinimumNumberofArrowstoBurstBalloons {
    // 首先，根据题目意思就是想让数组的重复区间更多，而投掷飞镖的数量就是所有非重叠区间的数量，也就是说题目的意思就是求非重叠区间的数量
    // 思路是，这题和435题差不多，先对数组按照第二个元素进行排序，然后尽量选择右边界尽量大的，这样非重叠区间的数量就少
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0)
            return 0;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int ans = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if(points[i][0]<=end)
                continue;
            ans++;
            end = points[i][1];
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
