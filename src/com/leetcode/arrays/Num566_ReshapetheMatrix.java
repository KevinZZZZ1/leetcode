package com.leetcode.arrays;

// Input:
// nums =
// [[1,2],
// [3,4]]
// r = 1, c = 4
//
// Output:
// [[1,2,3,4]]
//
// Explanation:
// The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.

// 完成一个对矩阵的reshape函数，r表示目标矩阵的行数，c表示目标矩阵的列数；如果操作不成功，返回原矩阵
public class Num566_ReshapetheMatrix {
    // 思路是：按照数组按列存储的方法，并且使用index表示矩阵中的第几个元素
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rOriginal = nums.length, cOriginal = nums[0].length;

        if(rOriginal*cOriginal!=r*c)
            return nums;

        int[][] ret = new int[r][c];
        int index=0;
        for(int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                ret[i][j] = nums[index/cOriginal][index%cOriginal];

                index++;
            }
        }

        return ret;
    }

    public static void main(String[] args) {

    }

}
