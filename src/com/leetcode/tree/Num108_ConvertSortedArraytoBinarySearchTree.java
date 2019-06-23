package com.leetcode.tree;
// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


// 给定一个升序的整型数组，将它转换为高度平衡的BST，即二叉树两个子树的高度差不大于1
public class Num108_ConvertSortedArraytoBinarySearchTree {
    // 思路是：为了保证高度平衡，那么要使用类似二分查找的思想
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length-1);
    }

    private TreeNode toBST(int[] nums, int sIndex, int eIndex){
        if(sIndex>eIndex)
            return null;
        int mid = sIndex + (eIndex-sIndex)>>2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums, sIndex, mid-1);
        root.right = toBST(nums, mid+1, eIndex);

        return root;
    }

    public static void main(String[] args) {

    }

}
