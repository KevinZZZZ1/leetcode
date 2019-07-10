package com.leetcode.twopointer;
// 在有序数组中找出两个数，使它们的和为 target
public class Num167_Two_SumII {
    // 思路是：使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。
    // 指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
    public int[] twoSum(int[] numbers, int target) {
        int i=0, j=numbers.length-1;
        while (i<j){
            int ans = numbers[i] + numbers[j];
            if(ans==target)
                return new int[]{numbers[i], numbers[j]};
            else if (ans>target){
                j--;
            }else {
                i++;
            }

        }
        return null;
    }

    public static void main(String[] args) {

    }

}
