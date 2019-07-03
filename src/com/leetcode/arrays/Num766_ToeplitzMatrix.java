package com.leetcode.arrays;
// Input:
//matrix = [
//  [1,2,3,4],
//  [5,1,2,3],
//  [9,5,1,2]
//]
//Output: True
//Explanation:
//In the above grid, the diagonals are:
//"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
//In each diagonal all elements are the same, so the answer is True.

//给定一个矩阵，判断该矩阵对角线上的元素是否相等
public class Num766_ToeplitzMatrix {
    // 思路是：本题思路很直接就是根据定义判断矩阵对角线上的元素是否相等
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        for(int i=0; i<m; i++){
            if(!check(matrix, i, 0, matrix[i][0]))
                return false;
        }

        for (int j = 0; j < n; j++) {
            if(!check(matrix, 0, j, matrix[0][j]))
                return false;
        }

        return true;
    }

    // 判断matrix[i][j]是否等于expected
    private boolean check(int[][] matrix, int i, int j, int expected){
        if(i>=matrix.length || j>=matrix[0].length)
            return true;

        if(matrix[i][j]!=expected)
            return false;
        return check(matrix, i+1, j+1, expected);
    }

    public static void main(String[] args) {

    }

}
