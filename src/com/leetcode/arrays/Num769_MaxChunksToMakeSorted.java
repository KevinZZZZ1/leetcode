package com.leetcode.arrays;


// 数组arr是[0, 1, ..., arr.length - 1]的一种排列，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
//
//我们最多能将数组分成多少块？
public class Num769_MaxChunksToMakeSorted {

    public int maxChunksToSorted(int[] arr) {
        if (arr == null) return 0;
        int ret = 0;
        int right = arr[0];
        for (int i = 0; i < arr.length; i++) {
            right = Math.max(right, arr[i]);
            if (right == i) ret++;
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] test = {1,0,2,3,4};
        Num769_MaxChunksToMakeSorted n = new Num769_MaxChunksToMakeSorted();
        n.maxChunksToSorted(test);


    }

}
