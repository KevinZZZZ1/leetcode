package com.leetcode.math;

// Given a positive integer num, write a function which returns True if num is a perfect square else False.

// 给定一个正整数，判断该数是否为某个数的平方


public class Num367_ValidPerfectSquare {
    // 根据序列：    0,1,2,3,4...
    // 其平方序列：  0,1,4,9,16...
    // 平方序列的差： 1,3,5,7...
    // 由此可看出，平方序列的差是一个等差数列，首项为1，公差为2；
    public static boolean isPerfectSquare(int num) {
        int subNum=1;
        while(num>0){
            num -= subNum;
            subNum += 2;
        }
        return num==0;
    }

    public static void main(String[] args) {
        int test1 = 16;
        int test2 = 14;
        if(isPerfectSquare(test1))
            System.out.println("yes");
        else
            System.out.println("no");
//        isPerfectSquare(test2);
    }


}
