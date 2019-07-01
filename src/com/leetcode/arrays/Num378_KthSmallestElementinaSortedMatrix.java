package com.leetcode.arrays;
// Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
//
//Note that it is the kth smallest element in the sorted order, not the kth distinct element.

// matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//return 13.

// 给定n×n矩阵，其中每个行和列按升序排序，找到矩阵中的第k个最小元素。
public class Num378_KthSmallestElementinaSortedMatrix {
    // 思路是：对于二分查找来说，最重要的是搜索空间，搜索空间分为范围搜索和索引搜索，这里由于矩阵内部并没排序，所以为范围搜索(range search)，即从最小值到最大值的范围；
    // 具体来说就是，根据矩阵中最大、最小值找到中间值，然后遍历矩阵，记下比中间值小的元素个数，
    // 如果记录数大于k，则在左半边区间；
    // 否则在右半边区间；
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n-1][n-1];
        while (lo<=hi){
            int mid = lo + (hi-lo)/2;
            int cnt=0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(matrix[i][j]>mid)
                        break;
                    cnt++;
                }
            }
            if(cnt<k)
                lo = mid+1;
            else
                hi = mid-1;
        }

        return lo;
    }


    public static void main(String[] args) {

    }

}
