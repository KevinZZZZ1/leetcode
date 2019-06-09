package com.leetcode.arrays;

//在一个长度为n的数组里的所有数字都在0到n-1的范围内。
// 数组中某些数字是重复的，但不知道有几个数字是重复的。
// 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
public class DeleteDuplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {

        if(length==0 || numbers==null)
            return false;

        for(int i=0; i<length; i++){
            while(numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]] && numbers[i]!=i){
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, numbers[i], i);
            }


        }
        return false;
    }

    private void swap(int[] numbers, int i, int j){
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }


    public static void main(String[] args){

        int[] test = new int[]{2,3,1,0,2,5,3};
        int[] ans = new int[1];
        DeleteDuplicate d = new DeleteDuplicate();
        d.duplicate(test,7, ans);
    }

}
