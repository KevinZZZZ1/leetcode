package com.leetcode.twopointer;
// 给定一个非空的整型数组[a1, a2, ...,an]，其中ai表示一个点(i, ai)，并且每个点都和(i, 0)形成一条直线，找出两条直线使得它们构成的面积最大
public class Num11_ContainerWithMostWater {
    // 思路一：暴力搜索法，设置两个指针遍历数组能构成的所有直线，求出能构成最大面积值
//    public int maxArea(int[] height) {
//        int max = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j=i+1; j<height.length; j++){
//                int area = (j-i) * Math.min(height[i], height[j]);
//                max = Math.max(max, area);
//            }
//        }
//        return max;
//    }

    // 思路二：使用双指针法，设置两个指针i,j分别指向数组首尾，比较height[i]和height[j]的大小
    // 如果height[i]>height[j] 则j--；否则i++
    public int maxArea(int[] height){
        int max = 0;
        int i=0, j=height.length-1;
        while (i<j){
            int area = (j-i)*Math.min(height[i], height[j]);
            max = Math.max(area, max);

            if(height[i]>height[j])
                j--;
            else
                i++;
        }

        return max;
    }




    public static void main(String[] args) {

    }

}
