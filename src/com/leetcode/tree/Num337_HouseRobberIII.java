package com.leetcode.tree;
// The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
//
//Determine the maximum amount of money the thief can rob tonight without alerting the police.


// 给定一个二叉树，在不能连续访问某个节点本身和其父节点、子节点的情况下，找出所有节点值得最大值s
public class Num337_HouseRobberIII {

    public int rob(TreeNode root) {
        if(root==null)
            return 0;

        int valTmp = root.val;

        if(root.left!=null)
            valTmp+=rob(root.left.left)+rob(root.left.right);
        if(root.right!=null)
            valTmp+=rob(root.right.left)+rob(root.right.right);
        int valTmp1 = rob(root.left)+rob(root.right);

        return Math.max(valTmp, valTmp1);
    }

    public static void main(String[] args) {

    }

}
