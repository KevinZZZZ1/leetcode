package com.leetcode.math;
// 求 1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case 等关键字及条件判断语句 A ? B : C
public class Sum {
    public static int Sum_Solution(int n){
        int sum = n;
        boolean b = (n>0) && ((sum+=Sum_Solution(n-1))>0);

        return sum;

    }

    public static void main(String[] args){
        int n = 10;
        Sum_Solution(n);
    }

}
