package com.leetcode.graph;

// Given an undirected graph, return true if and only if it is bipartite.

// Input: [[1,3], [0,2], [1,3], [0,2]]
//
// 0[[1,3],
// 1[0,2],
// 2[1,3],
// 3[0,2]]
// Output: true
// Explanation:
// The graph looks like this:
//0----1
//|    |
//|    |
//3----2
// We can divide the vertices into two groups: {0, 2} and {1, 3}.


import java.util.Arrays;

// 给定一个无向图，判断该图是否为二分图。
// 二分图是指：如果可以用两种颜色对图中的节点进行着色，并且保证相邻的节点颜色不同，那么这个图就是二分图。
public class Num785_IsGraphBipartite {
    // graph的行数表示图中点数，<i, graph[i][j]>表示点i到点graph[i][j]的边
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++) {  // 处理图不是连通的情况
            if (colors[i] == -1 && !isBipartite(i, 0, colors, graph)) {
                return false;
            }
        }
        return true;
    }

    private boolean isBipartite(int curNode, int curColor, int[] colors, int[][] graph) {
        if (colors[curNode] != -1) {
            return colors[curNode] == curColor;
        }
        colors[curNode] = curColor;
        for (int nextNode : graph[curNode]) {
            if (!isBipartite(nextNode, 1 - curColor, colors, graph)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }


}
