package com.leetcode.stackandqueue;
// Given a list of daily temperatures T,
// return a list such that, for each day in the input,
// tells you how many days you would have to wait until a warmer temperature.
// If there is no future day for which this is possible, put 0 instead.

// Input: [73, 74, 75, 71, 69, 72, 76, 73]
// Output: [1, 1, 4, 2, 1, 1, 0, 0]

import java.util.*;

// 给定一个数组，记录下数组元素到达下一个比它大的元素之间的距离
public class Num739_DailyTemperatures {
    // 思路是：在遍历数组的时候，用栈把数组存起来，如果当前遍历的数比栈顶元素大，说明栈顶元素的下一个比它大的数就是当前元素
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] dist = new int[n];
        Stack<Integer> indexs = new Stack<>();
        for (int curIndex = 0; curIndex < n; curIndex++) {
            while (!indexs.isEmpty() && T[curIndex] > T[indexs.peek()]) {
                int preIndex = indexs.pop();
                dist[preIndex] = curIndex - preIndex;
            }
            indexs.push(curIndex);
        }
        return dist;
    }

    public static void main(String[] args) {
        int[] test = {73, 74, 75, 71, 69, 72, 76, 73};

        Num739_DailyTemperatures n = new Num739_DailyTemperatures();
        n.dailyTemperatures(test);

    }

}
