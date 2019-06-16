package com.leetcode.tree;
// Given a binary tree, determine if it is height-balanced.


// 给定一个二叉树，判断其是否是平衡二叉树
// 平衡二叉树是指，左右子树的高度相差不大于1
public class Num104_MaximumDepthofBinaryTree {
    // 采用递归的方式，判断二叉树root及其每个子树的平衡性

    private boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        maxDepth(root);
        return this.isBalanced;
    }


    private int maxDepth(TreeNode root){
        if(root==null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        if(Math.abs(right-left)>1)
            this.isBalanced = false;
        return Math.max(left, right)+1;
    }

    public static void main(String[] args) {

    }
}
