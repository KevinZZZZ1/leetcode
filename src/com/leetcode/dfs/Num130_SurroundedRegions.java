package com.leetcode.dfs;
// 给定一个矩阵包含字符'X','O'，使被'X'包围的'O'都替换为'X'

// Example:
//
//        X X X X
//        X O O X
//        X X O X
//        X O X X
//        After running your function, the board should be:
//
//        X X X X
//        X X X X
//        X X X X
//        X O X X
public class Num130_SurroundedRegions {
    // 思路是，先遍历矩阵边界上的元素，这样保证与边界'O'连接所有的'O'的区域一定不能替换为'X'
    // 再遍历矩阵中其他各元素，判断该元素是否为'O'，如果是的话，从该点开始dfs找出所有连通区域，并且将其替换为'X'
    private int m,n;
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    private boolean[][] visited;
    public void solve(char[][] board) {
        if(board==null || board.length==0)
            return;

        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        // 遍历左，右边界
        for (int i = 0; i < m; i++) {
            if (board[i][0]=='O')
                dfs(board, i, 0, 'O');
            if(board[i][n-1]=='O')
                dfs(board, i, n-1, 'O');
        }

        // 遍历上，下边界
        for (int i = 0; i < n; i++) {
            if (board[0][i]=='O')
                dfs(board, 0, i, 'O');
            if (board[m-1][i]=='O')
                dfs(board, m-1, i, 'O');
        }

        // 遍历其他部分
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (!visited[i][j] && board[i][j]=='O')
                    dfs(board, i, j, 'X');
            }
        }


    }
    // 以board[i][j]位置元素作为起点，进行dfs寻找所有'O'区域
    private void dfs(char[][] board, int i, int j, char c){
        if (i<0 || i>=m || j<0 || j>=n || visited[i][j])
            return;
        // 只有board[i][j]为'O'时才需要继续遍历
        if (board[i][j]!='O')
            return;
        board[i][j]= c;
        visited[i][j] = true;
        for (int[] d: directions){
            dfs(board, i+d[0], j+d[1], c);
        }

    }

    public static void main(String[] args) {
        char[][] test = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};

        Num130_SurroundedRegions n =  new Num130_SurroundedRegions();
        n.solve(test);

    }

}
