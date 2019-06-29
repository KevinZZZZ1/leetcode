package com.leetcode.string;

// Determine whether an integer is a palindrome.
// An integer is a palindrome when it reads the same backward as forward.

// 给定一个整数，判断其是否为回文整数，要求不能将整数变为字符串处理，也不能使用额外空间
public class Num9_PalindromeNumber {
    // 将整数分成左右两部分，右边那部分需要转置，然后判断这两部分是否相等。
    public boolean isPalindrome(int x) {
        if(x==0)
            return true;

        if(x<0 || x%10==0)
            return false;

        int right=0;
        while (x>right){
            // x%10表示得到x最低位的数字
            // right*10 + x%10表示得到x靠右边的部分并且反转
            right = right*10 + x%10;
            x/=10;
        }

        return x==right || x==right/10;
    }

    public static void main(String[] args) {

    }


}
