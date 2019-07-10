package com.leetcode.twopointer;
// 给定一个非负整数c，判断是否存在两个整数a，b，使得a^2+b^2=c
public class Num633_SumofSquareNumbers {
    // 思路是：使用两个指针i，j指向[0, sqrt(c)]的首尾，然后不断遍历区间中的数，直到i>j
    public boolean judgeSquareSum(int c) {
        int i=0, j= (int)Math.sqrt(c);
        while(i<=j){
            int ans = i*i + j*j;
            if(ans == c)
                return true;
            else if(ans>c){
                j--;
            }else {
                i++;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }

}
