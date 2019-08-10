package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 在 n*n 的矩阵中摆放 n 个皇后，并且每个皇后不能在同一行，同一列，同一对角线上，求所有的 n 皇后的解
// 一行一行地摆放，在确定一行中的那个皇后应该摆在哪一列时，需要用三个标记数组来确定某一列是否合法，
// 这三个标记数组分别为：列标记数组、45 度对角线标记数组和 135 度对角线标记数组
public class Num51_NQueens {
    // 45 度对角线标记数组的长度为 2 * n - 1，对于在(r, c) 的位置的元素对应的所在的数组下标为 r + c
    // 135 度对角线标记数组的长度也是 2 * n - 1，对于在(r, c) 的位置的元素对应的所在的数组下标为 n - 1 - (r - c)
    private List<List<String>> ans;
    private char[][] nQueens;
    private boolean[] colUsed; // 列
    private boolean[] diagonals45Used; // 45度对角线
    private boolean[] diagonals135Used; // 135度对角线
    private int n;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        nQueens = new char[n][n];
        // 初始化棋盘
        for (int i=0; i<n; i++){
            Arrays.fill(nQueens[i], '.');
        }

        colUsed = new boolean[n];
        diagonals45Used = new boolean[2*n -1];
        diagonals135Used = new boolean[2*n -1];
        this.n = n;

        backtracking(0);

        return ans;
    }

    private void backtracking(int row) {
        // 说明棋盘已经处理完成了
        if (row == n){
            List<String> list = new ArrayList<>();
            for (char[] c: nQueens){
                list.add(new String(c));
            }
            ans.add(list);
            return;
        }

        for (int col=0; col<n; col++){
            int diagonals45Idx = row + col;
            int diagonals135Idx = n - 1 - (row - col);
            if (colUsed[col] || diagonals45Used[diagonals45Idx] || diagonals135Used[diagonals135Idx])
                continue;

            nQueens[row][col] = 'Q';
            colUsed[col] = true;
            diagonals45Used[diagonals45Idx] = true;
            diagonals135Used[diagonals135Idx] = true;

            backtracking(row+1);

            nQueens[row][col] = '.';
            colUsed[col] = false;
            diagonals45Used[diagonals45Idx] = false;
            diagonals135Used[diagonals135Idx] = false;
        }

    }

    public static void main(String[] args) {

    }

}
