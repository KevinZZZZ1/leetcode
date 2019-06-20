package com.leetcode.tree;
// Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
//
//The length of path between two nodes is represented by the number of edges between them.

// 给定一个二叉树，找出相同节点值得最长路径
public class Num687_LongestUnivaluePath {
    // 思路是：使用一个变量来记录路径的长度，然后使用dfs（深度优先搜索来遍历）

    private int path=0;

    public int longestUnivaluePath(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root);
        return path;
    }

    private int dfs(TreeNode root){
        if(root==null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);

        int leftPath = root.left!=null && root.left.val==root.val? left+1: 0;
        int rightPath = root.right!=null && root.right.val==root.val? right+1: 0;

        path = Math.max(path, leftPath+rightPath);

        return Math.max(leftPath, rightPath);

    }


    public static void main(String[] args) {

    }
}
