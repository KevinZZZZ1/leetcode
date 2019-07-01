package com.leetcode.arrays;
// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//Integers in each row are sorted in ascending from left to right.
//Integers in each column are sorted in ascending from top to bottom.


// 给定一个mxn的矩阵，判断是否能从中找出元素target，该矩阵有以下特点：
//  每行中的整数按从左到右的升序排序。
//  每列中的整数按从上到下的升序排序
public class Num240_Searcha2DMatrixII {
    // 剑指Offer上的原题，思路是：根据矩阵的特性，使用二分查找的方法，由于矩阵的左上角元素比同行的元素大，比同列的元素小，刚好就是中间元素
    // 所以每次比较都是基于矩阵左上角的元素
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;

        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n-1;
        while(i<m && j>=0){

            int tmp = matrix[i][j];
            if(tmp == target)
                return true;
            else if(tmp > target)
                j--;
            else
                i++;

        }
        return false;
    }


    public static void main(String[] args) {

    }


}
