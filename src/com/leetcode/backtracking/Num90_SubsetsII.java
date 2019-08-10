package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 给定一个包含重复元素的数组nums，找出集合的所有子集
//Input: [1,2,2]
//        Output:
//        [
//        [2],
//        [1],
//        [1,2,2],
//        [2,2],
//        [1,2],
//        []
//        ]

public class Num90_SubsetsII {
    // 数组元素可能含有相同的元素，进行排列时就有可能出现重复的排列，要求重复的排列只返回一个
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums==null || nums.length==0)
            return ans;

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        // 求出所有数量的子集
        for (int subsetSize = 1; subsetSize <= nums.length; subsetSize++) {
            backtracking(ans, new ArrayList<>(), nums, subsetSize, visited, 0);
        }
        // 空集
        ans.add(new ArrayList<>());
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> tmp, int[] nums, int subsetSize, boolean[] visited, int start) {
        if (tmp.size()==subsetSize) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i!=0 && nums[i-1]==nums[i] && !visited[i-1])
                continue;
            tmp.add(nums[i]);
            visited[i] = true;
            backtracking(ans, tmp, nums, subsetSize, visited, i+1);
            tmp.remove(tmp.size()-1);
            visited[i] = false;
        }
    }


    public static void main(String[] args) {
        Num90_SubsetsII n = new Num90_SubsetsII();
        int[] test = {1,2,2};
        n.subsetsWithDup(test);
    }
}
