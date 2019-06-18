package com.leetcode.tree;
// Given a binary tree, find its minimum depth.
//
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.


// 给定一个二叉树，找出从根节点开始到叶子节点最低的高度
public class Num111_Minimum_DepthofBinaryTree {
    // 思路是：对于某个节点来说，到叶子节点的最小高度为左右孩子中最小高度加1，如此可以递归下去求解；
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // 如果没有左子树或没有右子树或没有左右子树
        if(left==0 || right==0)
            return left+right+1;

        return Math.min(left, right)+1;
    }

    public static void main(String[] args) {

    }
}
