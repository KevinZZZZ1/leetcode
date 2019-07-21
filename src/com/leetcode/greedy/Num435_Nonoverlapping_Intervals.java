package com.leetcode.greedy;

// Input: [ [1,2], [2,3], [3,4], [1,3] ]
//
// Output: 1
//
// Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.

import java.util.Arrays;
import java.util.Comparator;

// 给定一组区间，找到使得这些区间不再重叠需要移除的最小区间数
public class Num435_Nonoverlapping_Intervals {
    // 思路是，想移除最少的区间数从而使得区间不重叠，那么就要保证每次选择的区间的右边界尽量的小，这样留下的区间可操作性就越强
    public int eraseOverlapIntervals(int[][] intervals) {

        if(intervals == null)
            return 0;
        // 按照数组中第二个元素排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int ans = 1;
        int end = intervals[0][1];
        for (int i=1; i<intervals.length; i++){
            // 满足合并区间的条件
            if(end<=intervals[i][0]) {
                end = intervals[i][1];
                ans++;
            }
            else
                continue;
        }

        return intervals.length - ans;
    }

    public static void main(String[] args) {

    }

}
