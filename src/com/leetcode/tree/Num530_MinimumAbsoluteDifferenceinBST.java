package com.leetcode.tree;

// Given a binary search tree with non-negative values,
// find the minimum absolute difference between values of any two nodes.

// 给定一个节点值为非负数的BST，找出两个节点值之差的绝对值最小值
public class Num530_MinimumAbsoluteDifferenceinBST {
    // 思路是，这道题的思路和653题差不多，先是对BST中序遍历得到一个有序的序列，再求节点差绝对值最小
    // 但是，没有必要构建数组，因为序列是有序的，那么节点差绝对值最小一定出现在相邻节点

    private TreeNode pre;
    private int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode root){
        if(root==null)
            return;

        inOrder(root.left);
        if(pre!=null)
            minDiff = Math.min(minDiff, root.val-pre.val);
        pre = root;
        inOrder(root.right);
    }

    public static void main(String[] args) {

    }

}
