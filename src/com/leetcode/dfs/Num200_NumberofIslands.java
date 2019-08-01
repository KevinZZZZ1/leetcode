package com.leetcode.dfs;
// 给定一个字符矩阵grid，'0'表示水，'1'表示陆地，计算出grid中岛的个数
//Input:
//        11000
//        11000
//        00100
//        00011
//
//        Output: 3
public class Num200_NumberofIslands {
    // 思路是，遍历矩阵中所有元素，对于某个元素遍历与它连通的所有节点
    private int m, n;
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0)
            return 0;

        m = grid.length;
        n = grid[0].length;
        int cnt=0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]!='0'){
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]=='0')
            return;
        grid[i][j] = '0';
        for (int[] d: directions){
            dfs(grid, i+d[0], j+d[1]);
        }
    }

    public static void main(String[] args) {

    }

}
