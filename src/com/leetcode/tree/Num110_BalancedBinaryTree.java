package com.leetcode.tree;

// Given a binary tree, find its maximum depth.
//
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.


// 给定一个二叉树，找出其高度
public class Num110_BalancedBinaryTree {
    // 思路其实很简单，就是使用递归的方式
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;

        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {

    }

}
