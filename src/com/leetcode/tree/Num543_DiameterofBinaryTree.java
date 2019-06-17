package com.leetcode.tree;

// Given a binary tree, you need to compute the length of the diameter of the tree.
// The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
// This path may or may not pass through the root.

// 给定一个二叉树，求出树中两个节点间最长路径
public class Num543_DiameterofBinaryTree {
    // 思路是：两个节点间的最长路径可以分解为，以某个节点为根，左子树和右子树的深度之和的最大值。
    private int max=0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode root){
        if(root==null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        this.max = Math.max(max, (left+right));
        return 1+Math.max(left, right);
    }

    public static void main(String[] args) {

    }

}
