package com.leetcode.dfs;
// 一个班上共有N个人，给定一个矩阵M表示N个人之间的关系，其大小为N*N，M[i][j]=1表示第i个人和第j个人是朋友关系
// A是B的朋友，B是C的朋友，那么A也是C的朋友；
// 计算班上有多少个朋友圈
public class Num547_FriendCircles {
    // 思路是，遍历M中所有元素，从某个元素开始使用dfs获得该元素所在的朋友圈
    private int n;

    public int findCircleNum(int[][] M) {
        n = M.length;
        int circleNum = 0;
        boolean[] hasVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!hasVisited[i]) {
                dfs(M, i, hasVisited);
                circleNum++;
            }
        }
        return circleNum;
    }

    private void dfs(int[][] M, int i, boolean[] hasVisited) {
        hasVisited[i] = true;
        for (int k = 0; k < n; k++) {
            if (M[i][k] == 1 && !hasVisited[k]) {
                dfs(M, k, hasVisited);
            }
        }
    }

    public static void main(String[] args) {

    }

}
