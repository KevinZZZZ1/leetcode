package com.leetcode.tree;
// Given two binary trees and imagine that when you put one of them to cover the other,
// some nodes of the two trees are overlapped while the others are not.
//
//You need to merge them into a new binary tree.
// The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
// Otherwise, the NOT null node will be used as the node of new tree.

// 给定两个二叉树，将它们进行重叠、合并，规则是：在某个位置如果两个树都不为空，则新树节点的值为它们之和；否则就为其中一个节点；

//Input:
//        Tree 1                     Tree 2
//         1                         2
//        / \                       / \
//        3   2                     1   3
//        /                           \   \
//        5                             4   7
//        Output:
//        Merged tree:
//         3
//        / \
//        4   5
//         / \   \
//        5   4   7

public class Num617_MergeTwoBinaryTrees {
    // 思路是：对于某个节点来说，要实现合并操作只要根据规则进行合并即可，其左孩子和右孩子可以通过递归的方式求解；
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if(t1==null && t2==null)
            return null;
        if(t1==null) return t2;
        if(t2==null) return t1;

        TreeNode tmp = new TreeNode(t1.val+t2.val);
        tmp.left = mergeTrees(t1.left, t2.left);
        tmp.right = mergeTrees(t1.right, t2.right);

        return tmp;
    }


    public static void main(String[] args) {

    }
}
