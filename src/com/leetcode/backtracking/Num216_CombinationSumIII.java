package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

// 给定一个整数n，k，在[1,9]的区间内选择k个不同的数，使得这些数的和为n
//        Input: k = 3, n = 9
//        Output: [[1,2,6], [1,3,5], [2,3,4]]

public class Num216_CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k==0 || n==0)
            return ans;

        backtracking(ans, new ArrayList<>(), k, n, 1);

        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> tmp, int k, int n, int start) {
        if (k==0 && n==0){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i=start; i<=9; i++){
            if (i<=n && k>0){
                tmp.add(i);
                backtracking(ans, tmp, k-1, n-i, i+1);
                tmp.remove(tmp.size()-1);
            }
        }

    }

    public static void main(String[] args) {
        int k=3, n=7;
        Num216_CombinationSumIII t = new Num216_CombinationSumIII();
        t.combinationSum3(k, n);
    }

}
