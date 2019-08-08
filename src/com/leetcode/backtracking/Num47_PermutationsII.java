package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 给定一个数组nums，其中可能会包含重复元素，返回所有不同元素的排列
//Input: [1,1,2]
//        Output:
//        [
//        [1,1,2],
//        [1,2,1],
//        [2,1,1]
//        ]

public class Num47_PermutationsII {
    // 数组元素可能含有相同的元素，进行排列时就有可能出现重复的排列，要求重复的排列只返回一个
    // 先排序，然后在添加一个元素时，判断这个元素是否等于前一个元素，如果等于，并且前一个元素还未访问，那么就跳过这个元素
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);  // 排序
        boolean[] hasVisited = new boolean[nums.length];
        backtracking(new ArrayList<Integer>(), ans, hasVisited, nums);
        return ans;

    }

    private void backtracking(List<Integer> tmp, List<List<Integer>> ans, boolean[] visited, int[] nums) {
        if (tmp.size()==nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;  // 防止重复
            }
            if (visited[i]){
                continue;
            }
            visited[i] = true;
            tmp.add(nums[i]);
            backtracking(tmp, ans, visited, nums);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }

    }

}
