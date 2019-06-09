package com.leetcode.math;
// 给定数字n，求出[0,n]之间所有的素数
public class Num204_CountPrimes {
    // 使用埃拉托斯特尼筛法
    public static int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n+1]; // 位置i为true表示不是素数，为false表示为素数；
        int count=0;
        for(int i=2; i<n; i++){
            if(notPrimes[i])
                continue;
            // i是素数，则i的倍数k*i一定不是素数
            // 本来是应该从i开始的，但是k<i时，之前一定去除过
            for (long j = (long)i*(long)i; j < n; j=i+j) {
                notPrimes[(int)j] = true;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int test = 10;
        countPrimes(test);
    }


}
