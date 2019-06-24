package com.leetcode.tree;


import java.util.ArrayList;
import java.util.List;

// Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.


// 给定一个BST和一个数，判断在BST中是否存在两个节点的值之和为给定的数
public class Num653_TwoSumIV_InputisaBST {
    // 思路是，使用中序遍历得到有序数组，然后再使用双指针对数组进行查找
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        if (root==null)
            return false;

        inOrder(root, nums);

        int i=0, j=nums.size()-1;
        while (i<j){
            int tmp = nums.get(i)+nums.get(j);
            if(k==tmp)
                return true;
            if(k>tmp)
                i++;
            else
                j--;
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> nums){

        if(root==null)
            return;
        inOrder(root.left, nums);

        nums.add(root.val);

        inOrder(root.right, nums);
    }



    public static void main(String[] args) {

    }


}
