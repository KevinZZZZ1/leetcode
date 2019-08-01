package com.leetcode.dfs;
// 给定一个矩阵grid，grid中1表示一个小岛，求出grid中最大的连通的岛的面积
public class Num695_MaxAreaofIsland {
    // 思路是，遍历矩阵中每个元素，然后从该元素出发进行dfs并记录下与该元素连通的点的数量
    private int m, n;
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid==null || grid.length==0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        int maxArea=0;

        for (int i=0; i<m; i++){
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        if(i<0 || i>=m || j<0 || j>=m || grid[i][j]==0)
            return 0;
        // 将grid[i][j]置为0表示已经访问过
        grid[i][j] = 0;
        int cnt=1;
        for (int[] d: directions){
            cnt += dfs(grid, i+d[0], j+d[1]);
        }
        return cnt;
    }

    public static void main(String[] args) {

    }

}
