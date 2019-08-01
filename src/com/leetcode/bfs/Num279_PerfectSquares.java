package com.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 给定一个正整数n，使得若干个完美平方数（例如1,4,9,16...）的和为n，求出需要的完美平方数最少的个数
// Input: n = 13
// Output: 2
// Explanation: 13 = 4 + 9.
public class Num279_PerfectSquares {
    // 思路是，可以将每个整数看成图中的一个节点，如果两个整数之差为一个平方数，那么这两个整数所在的节点就有一条边。
    // 要求解最小的平方数数量，就是求解从节点 n 到节点 0 的最短路径。
    // 先使用一个函数创建出在n范围内所有完美平方数，
    // 然后使用一个队列来记录访问的节点，使用一个boolean数组来记录节点是否访问过
    public int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();


        boolean[] visited = new boolean[n+1];
        queue.add(n);
        int step=0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            while (size-->0){
                int cur = queue.poll();
                // 如何保证是最少的完美平方数的个数：这个循环相当于是从n开始和所有平方数比较，最后从循环中break的一定是最先diff为0的，也就是路径最短的
                for(int s: squares){
                    int diff = cur - s;
                    if (diff<0)
                        break;
                    if(diff==0)
                        return step;
                    if(visited[diff])
                        continue;

                    visited[diff] = true;
                    queue.add(diff);
                }
            }
        }

        return n;
    }

    // 生成n以内所有的平方数
    private List<Integer> generateSquares(int n){
        if (n<0)
            return null;
        List<Integer> ret = new ArrayList<>();
        int s = 1;
        int diff=3;
        while (s<=n){
            ret.add(s);
            s += diff;
            diff += 2;
        }
        return ret;
    }

    public static void main(String[] args) {
        int test = 10;
        Num279_PerfectSquares n = new Num279_PerfectSquares();
        n.numSquares(test);
    }

}
