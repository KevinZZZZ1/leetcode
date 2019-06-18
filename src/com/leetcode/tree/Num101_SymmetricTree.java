package com.leetcode.tree;

// Given a binary tree,
// check whether it is a mirror of itself (ie, symmetric around its center).

// 给定一个二叉树，判断该树是否对称
public class Num101_SymmetricTree {
    // 思路是：根据对称的定义，根节点的左孩子和右孩子值一定要相等，而根节点的孙子节点则是不同的，孙子节点的对称性可转换为相等性
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode t1, TreeNode t2){
        if(t1==null && t2==null)
            return true;
        if(t1==null || t2==null || t1.val!=t2.val)
            return false;

        return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);

    }

    public static void main(String[] args) {

    }

}
