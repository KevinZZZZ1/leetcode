package com.leetcode.arrays;
import java.util.*;
public class CardContinuous {
    //给定五张牌，其中大小王，牌面大小为 0，但是可以代表任何数字。判断这五张牌是否能组成顺子。
    //
    public boolean isContinuous(int[] numbers){
        if(numbers.length<5)
            return false;
        Arrays.sort(numbers);

        int cnt =0;
        for(int n: numbers){
            if(n==0)
                cnt++;
        }

        for(int i=cnt; i<numbers.length-1; i++){
            if(numbers[i]==numbers[i+1])
                return false;
            cnt -= (numbers[i+1] - numbers[i] - 1);

        }
        return cnt>=0;
    }


    public static void main(String[] args){

    }

}
