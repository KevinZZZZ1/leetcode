package com.leetcode.backtracking;
import java.util.*;


public class Num78Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        // 回溯试图法，对某个元素来说，先选择放入，在选择一次不放入的过程叫做回溯试探法，这相当于构建了一颗二叉树，并且对二叉树进行遍历
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length==0)
            return ans;

        generate(0, nums, new LinkedList<>(), ans);
        ans.add(new LinkedList<>()); // 空集
        return ans;
    }

    private static void generate(int i, int[] nums, Deque<Integer> item, List<List<Integer>> ans){
        if(i>=nums.length)
            return;

        item.add(nums[i]);
        ans.add(new ArrayList<>(item));
        generate(i+1, nums, item, ans);
        item.removeLast();
        generate(i+1, nums, item, ans);


    }

    public static List<List<Integer>> subsets2(int[] nums) {
        // 位运算，假设A,B,C三个元素，那么可以用三位二进制数表示A,B,C是否在对应的位置，即A:100,B:010,C:001。对于某个数X（0~7）来说，如果X&A为正，则A在对应的集合中，否则不在；
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length==0)
            return ans;
        Map<Integer, Integer> map = new HashMap<>(); // 二进制数和对应数字的映射,例如100=>A
        for(int i=0; i<nums.length; i++){
            map.put(1<<i,nums[i]);
        }
        int size = (int)Math.pow(2, nums.length);
        for(int i=0; i<size; i++){
            List<Integer> item = new ArrayList<>();
            for(int j: map.keySet()){
                if((j&i)==j)
                    item.add(map.get(j));
            }

            ans.add(item);
        }


        return ans;


    }


    public static void main(String[] args){
        int[] test = new int[]{1,2,3};
        List<List<Integer>> ans = subsets(test);
        subsets2(test);
    }
}
