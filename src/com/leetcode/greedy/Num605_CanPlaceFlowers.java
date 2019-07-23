package com.leetcode.greedy;

// 给定一个数组flowerbed[]和一个整数n，flowerbed 数组中 1 表示已经种下了花朵。花朵之间至少需要一个单位的间隔，求解是否能种下 n 朵花
// Input: flowerbed = [1,0,0,0,1], n = 2
// Output: False
public class Num605_CanPlaceFlowers {

    // 思路是，遍历数组，用变量cnt来记录当前种花的数量，如果数组元素值为1，则直接continue
    // 否则判断该元素的前一个元素值、后一个元素值是否为1，
    // 如果两个都不为1，则将该处赋值为1，同时cnt++
    // 在这里最重要的就是要注意数组边界的时候的处理
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt=0, len = flowerbed.length;

        for (int i = 0; i < len && cnt <n; i++) {
            if(flowerbed[i] == 1)
                continue;

            // 处理数组边界的时候，防止出现越界异常
            int left = (i==0? 0: flowerbed[i-1]);
            int right = (i==len-1? 0: flowerbed[i+1]);

            if(left==0 && right==0){
                flowerbed[i] = 1;
                cnt++;
            }
        }


        return cnt>= n;
    }

    public static void main(String[] args) {

    }

}
