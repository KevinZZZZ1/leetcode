package com.leetcode.backtracking;

// 给定一个字符矩阵board以及字符串单词word，判断word是否存在于board之中
// 要求选择出来的字符必须是邻接的，而且每个字符只能选用一次
//board =
//        [
//        ['A','B','C','E'],
//        ['S','F','C','S'],
//        ['A','D','E','E']
//        ]
//
//        Given word = "ABCCED", return true.
//        Given word = "SEE", return true.
//        Given word = "ABCB", return false.

public class Num79_WordSearch {
    // 思路就是，遍历矩阵中每个元素，并且从每个元素开始进行回溯，
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    private int m,n;
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if (board==null || board.length==0)
            return false;

        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtracking(board, word, i, j, visited, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, String word, int i, int j, boolean[][] visited, int curIndex) {
        if (curIndex==word.length())
            return true;

        if (i<0 || i>=m || j<0 || j>=n || board[i][j]!=word.charAt(curIndex) || visited[i][j])
            return false;

        visited[i][j] = true;
        for (int[] d: directions){
            if (backtracking(board, word, i+d[0], j+d[1], visited, curIndex+1))
                return true;
        }
        visited[i][j] = false;
        return false;

    }

    public static void main(String[] args) {

    }

}
