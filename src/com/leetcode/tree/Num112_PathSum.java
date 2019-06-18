package com.leetcode.tree;
// Given a binary tree and a sum,
// determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.


import java.io.InputStream;

// 给定一个二叉树root和一个整数sum，判断该树是否存在一条从根到叶子的路径，使得该路径上元素值之和为sum
public class Num112_PathSum {
    // 思路是：可以使用递归的方法求解，先假设某个节点在该路径中，在判断其左孩子或右孩子是否在路径中
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        // 边界条件，也就是到达叶子节点时，存在的情况；如果不存在会再进行一次递归，会在第一个判断条件处返回false；
        if(root.left==null && root.right==null && root.val==sum)
            return true;

        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }



    public static void main(String[] args) {




    }
}
