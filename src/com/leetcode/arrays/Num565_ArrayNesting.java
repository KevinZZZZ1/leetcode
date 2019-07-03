package com.leetcode.arrays;


// 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到并返回最大的集合S，S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。

//假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
// 即：S[i] 表示一个集合，集合的第一个元素是 A[i]，第二个元素是 A[A[i]]，如此嵌套下去。求最大的 S[i]。
public class Num565_ArrayNesting {
    // 思路是：从数组第一个位置开始遍历数组，求出从第一元素开始符合嵌套数组定义的所有元素，并将访问的过元素都进行标记，记录下元素的个数
    public int arrayNesting(int[] nums) {
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            int tmp=0;
            for (int j = i; nums[j] !=-1 ; ) {
                tmp++;
                int t = nums[j];
                nums[j]=-1; // 标记该位置已经被访问
                j=t;
            }
            max = Math.max(max, tmp);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] test = {5,4,0,3,1,6,2};

        Num565_ArrayNesting n = new Num565_ArrayNesting();
        n.arrayNesting(test);

    }

}
