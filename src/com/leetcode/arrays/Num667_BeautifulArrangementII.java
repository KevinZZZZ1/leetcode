package com.leetcode.arrays;
// Given two integers n and k, you need to construct a list which contains n different positive integers ranging from 1 to n and obeys the following requirement:
// Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.

// Input: n = 3, k = 2
//Output: [1, 3, 2]
//Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3, and the [2, 1] has exactly 2 distinct integers: 1 and 2.

// 数组元素为 1到n 的整数，要求构建数组，使得相邻元素的差值不相同的个数为 k。
public class Num667_BeautifulArrangementII {
    // 思路是：这道题就是找规律
    // 当n = 50， k = 20时： [1,21,2,20,3,19,4,18,5,17,6,16,7,15,8,14,9,13,10,12,11,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50]
    // 当n = 50，k = 17时： [1,18,2,17,3,16,4,15,5,14,6,13,7,12,8,11,9,10,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50]
    // 当n = 80，k = 30时： [1,31,2,30,3,29,4,28,5,27,6,26,7,25,8,24,9,23,10,22,11,21,12,20,13,19,14,18,15,17,16,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80]
    // 规律，就是 数组的下标从[0, k]中，偶数下标填充[1,2,3…]，奇数下标填充[k + 1, k, k - 1…]，后面[k + 1, n - 1]都是顺序填充

    public int[] constructArray(int n, int k) {
        int[] ret = new int[n];
        ret[0]=1;
        for(int i=1; i<=k; i++){
            ret[i] = i%2==0? (i/2+1): (k+2-ret[i-1]);
        }

        for(int i=k+1; i<n; i++){
            ret[i] = i+1;
        }

        return ret;
    }

    public static void main(String[] args) {

    }

}
