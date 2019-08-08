package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
// 给定一个数组nums，不包含重复元素，求出这些元素所有的排列

//Input: [1,2,3]
//        Output:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//        ]
public class Num46_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums==null || nums.length==0)
            return ans;

        boolean[] visited = new boolean[nums.length];

        backtracking(nums, ans, new ArrayList<>(), visited);

        return ans;
    }

    private void backtracking(int[] nums, List<List<Integer>> ans, List<Integer> tmp, boolean[] visited) {
        if (tmp.size()==nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;

            tmp.add(nums[i]);
            visited[i] = true;
            backtracking(nums, ans, tmp, visited);
            visited[i] = false;
            tmp.remove(tmp.size()-1);
        }

    }

    public static void main(String[] args) {

    }

}
