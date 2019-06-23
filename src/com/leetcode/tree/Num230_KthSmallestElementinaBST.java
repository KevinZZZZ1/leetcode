package com.leetcode.tree;
// Given a binary search tree,
// write a function kthSmallest to find the kth smallest element in it.


// 给定一个二叉查找树，找出其中元素值是第k小的值
public class Num230_KthSmallestElementinaBST {
    // 思路是：由于中序遍历二叉查找树得到有序的节点值序列
    // 所以要查找第k小的值，可进行中序遍历，然后记录下已经遍历过的元素个数；

    private int val;
    private int count=0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return val;
    }

    private void inorder(TreeNode root, int k){
        if(root==null)
            return;
        inorder(root.left, k);
        count++;
        if(count==k) {
            val = root.val;
            return;
        }
        inorder(root.right, k);
    }

    public static void main(String[] args) {

    }
}
