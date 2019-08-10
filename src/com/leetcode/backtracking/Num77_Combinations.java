package com.leetcode.backtracking;


// 给定两个整数n，k，在[1,n]的范围内取出k个数所有的组合：
// Input: n = 4, k = 2
// Output:
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]

import java.util.ArrayList;
import java.util.List;

public class Num77_Combinations {
    // 思路是，使用回溯法，遍历[1,n]区间内所有元素，选择k个元素加入一个List中
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        backtracking(ans, new ArrayList<>(), n, k, 1);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> tmp, int n, int k, int start) {
        if (tmp.size()==k){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i <= n; i++) {
            tmp.add(i);
            backtracking(ans, tmp, n, k, i+1);
            tmp.remove(tmp.size()-1);
        }
        
    }

    public static void main(String[] args) {
        Num77_Combinations t = new Num77_Combinations();
        int n=4, k=2;
        t.combine(n, k);
    }

}
