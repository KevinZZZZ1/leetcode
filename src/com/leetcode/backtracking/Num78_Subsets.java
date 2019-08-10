package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
// 给定一个数组nums，找出集合的所有子集，子集不能重复，[1, 2] 和 [2, 1] 这种子集算重复

//Input: nums = [1,2,3]
//        Output:
//        [
//        [3],
//        [1],
//        [2],
//        [1,2,3],
//        [1,3],
//        [2,3],
//        [1,2],
//        []
//        ]
public class Num78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums==null || nums.length==0)
            return ans;

        // 得到数量不同的子集
        for (int subsetSize = 1; subsetSize <= nums.length; subsetSize++) {
            backtracking(ans, new ArrayList<>(), nums, 0, subsetSize);
        }

        ans.add(new ArrayList<>()); // 空集
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> tmp, int[] nums, int start, int subsetSize) {

        if (subsetSize==tmp.size()){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtracking(ans, tmp, nums, i+1, subsetSize);
            tmp.remove(tmp.size()-1);
        }

    }

    public static void main(String[] args) {
        Num78_Subsets n = new Num78_Subsets();
        int[] test={1,2,3};
        n.subsets(test);
    }

}
