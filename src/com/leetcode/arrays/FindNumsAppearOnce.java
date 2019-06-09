package com.leetcode.arrays;

public class FindNumsAppearOnce {
    // 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。



    // 由于两个相同的数异或值为0，所以将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int diff = 0;
        for (int num : array)
            diff ^= num;
        diff &= -diff; // diff &= -diff 得到出 diff 最右侧不为 0 的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来。
        for (int num : array) {
            if ((num & diff) == 0)
                num1[0] ^= num;
            else
                num2[0] ^= num;
        }
    }

    public static void main(String[] args){


    }
}
