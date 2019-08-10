package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

// 给定一个不包含重复值的数组candidates和一个整数target，从candidates中找出和为target的元素的所有组合
// Input: candidates = [2,3,5], target = 8,
// A solution set is:
// [
//   [2,2,2,2],
//   [2,3,3],
//   [3,5]
// ]

public class Num39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates==null || candidates.length==0)
            return ans;

        backtracking(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> tmp, int[] candidates, int target, int start) {
        if (target==0){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i]<=target){
                tmp.add(candidates[i]);
                backtracking(ans, tmp, candidates, target-candidates[i], i);
                tmp.remove(tmp.size()-1);
            }
        }

    }

    public static void main(String[] args) {
        Num39_CombinationSum n = new Num39_CombinationSum();
        int[] c = {2,3,6,7};
        int t = 7;
        n.combinationSum(c, t);
    }

}
