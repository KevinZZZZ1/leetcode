package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 给定一个不包含重复值的数组candidates和一个整数target，从candidates中找出和为target的不重复元素的所有组合
// Input: candidates = [10,1,2,7,6,1,5], target = 8,
// A solution set is:
// [
//   [1, 7],
//   [1, 2, 5],
//   [2, 6],
//   [1, 1, 6]
// ]

public class Num40_CombinationSumII {
    // 由于选取元素不能重复，所以使用的方法是：先对candidates进行排序，然后对于某个元素candidates[i]来说，如果它前一个元素candidates[i-1]和它值相等而且未被访问过，那么candidates[i]也不能被访问
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        if(candidates==null || candidates.length==0)
            return ans;

        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        backtracking(ans, new ArrayList<>(), candidates, target, visited, 0);

        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> tmp, int[] candidates, int target, boolean[] visited, int start) {


        if (target==0){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // 表示之前已经访问过这个元素了
            if (i!=0 && candidates[i-1]==candidates[i] && !visited[i-1])
                continue;

            if (candidates[i]<=target){
                tmp.add(candidates[i]);
                visited[i] = true;
                backtracking(ans, tmp, candidates, target-candidates[i], visited, i+1);
                tmp.remove(tmp.size()-1);
                visited[i] = false;
            }
        }


    }

}
