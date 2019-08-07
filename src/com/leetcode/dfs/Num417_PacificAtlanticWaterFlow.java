package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

// 给定一个非负整数mxn的矩阵，矩阵左边和上边是太平洋，右边和下边是大西洋，
// 内部的数字代表海拔，海拔高的地方的水能够流到低的地方，求解水既能够流到太平洋又大西洋的所有位置

//Given the following 5x5 matrix:
//
//        Pacific ~   ~   ~   ~   ~
//        ~  1   2   2   3  (5) *
//        ~  3   2   3  (4) (4) *
//        ~  2   4  (5)  3   1  *
//        ~ (6) (7)  1   4   5  *
//        ~ (5)  1   1   2   4  *
//        *   *   *   *   * Atlantic
//
//        Return:
//
//        [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).


public class Num417_PacificAtlanticWaterFlow {
    // 思路是，先从矩阵左边和上边边界开始遍历，寻找边界相连的所有图的位置，
    // 在从矩阵的右边和下边开始遍历，记录下所有连通的位置，
    // 在求解两个结果的交集就是答案
    private int m, n;
    private int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private List<List<Integer>> pAns;
    private List<List<Integer>> aAns;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix==null || matrix.length==0)
            return new ArrayList<>();;

        m = matrix.length;
        n = matrix[0].length;
        pAns = new ArrayList<>();
        aAns = new ArrayList<>();
        boolean[][] visitedA = new boolean[m][n];
        boolean[][] visitedP = new boolean[m][n];
        // 矩阵左边界 右边界
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, pAns, visitedP, matrix[i][0]);
            dfs(matrix, i, n-1, aAns, visitedA, matrix[i][n-1]);
        }

        // 矩阵上边界 下边界
        for (int i = 0; i < n; i++) {
            dfs(matrix, 0, i, pAns, visitedP, matrix[0][i]);
            dfs(matrix, m-1, i, aAns, visitedA, matrix[m-1][i]);
        }


        aAns.retainAll(pAns);
        return aAns;
    }

    private void dfs(int[][] matrix, int i, int j, List<List<Integer>> ans, boolean[][] visited, int pre) {
        if (i<0 || i>=m || j<0 || j>=n || visited[i][j] || pre>matrix[i][j])
            return;
        // 无论是否满足条件，该节点都是被访问过的
        visited[i][j] = true;
        // 将符合条件的节点坐标加入ans中
        if (pre<=matrix[i][j]){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(i);
            tmp.add(j);
            ans.add(tmp);
        }
        for (int[] d: directions){
            dfs(matrix, i+d[0], j+d[1], ans, visited, matrix[i][j]);
        }
    }

    public static void main(String[] args) {

    }

}
