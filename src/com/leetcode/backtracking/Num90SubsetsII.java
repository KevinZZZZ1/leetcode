package com.leetcode.backtracking;
import java.util.*;
public class Num90SubsetsII {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), ret);
        return ret;
    }

    private static void dfs(int[] nums, int idx, List<Integer> path, List<List<Integer>> ret) {
        ret.add(path);
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i-1]) {
                continue;
            }
            List<Integer> p = new ArrayList<>(path);
            p.add(nums[i]);
            dfs(nums, i+1, p, ret);
        }
    }

    public static void main(String[] args){
        int[] test = new int[]{2,1,2,2};
        subsetsWithDup(test);


    }


}
