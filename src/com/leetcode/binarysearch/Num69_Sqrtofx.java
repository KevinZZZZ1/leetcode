package com.leetcode.binarysearch;
// 实现求解x平方根的函数
// Input: 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since
//             the decimal part is truncated, 2 is returned.
public class Num69_Sqrtofx {
    // 思路是，使用二分查找，因为一个平方只能在0~x之间，并且满足sqrt*sqrt==x
    // 对于中间值mid来说：
        // 如果mid*mid==x，那么返回mid；
        // 如果mid*mid<x，那么l=mid+1;
        // 如果mid*mid>x，那么h=mid-1;
    // 需要注意的是，当while循环退出时，说明没有找到，而且是h<l了
    // 所以此时要返回h
    public static int mySqrt(int x) {
        if(x<=0)
            return x;
        int l=1, h=x;
        while (l<=h){
            int mid = l+(h-l)/2;
            // 不要使用mid*mid的方法，因为这样容易溢出
            int sqrt = x/mid;
            if(sqrt==mid)
                return mid;
            else if(sqrt<mid)
                h = mid-1;
            else
                l = mid+1;
        }
        return h;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(68));
    }

}
