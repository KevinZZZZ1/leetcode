package com.leetcode.tree;

// Invert a binary tree.

// 给定一个二叉树，将其翻转

// Input:

//    4
//  /   \
//  2     7
// / \   / \
//1   3 6   9

// Output:

//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1

public class Num226_InvertBinaryTree {
    // 思路是，通过递归的方式，将某个节点的左孩子和右孩子进行调换，通过递归就能达到翻转二叉树的目的
    public static TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode tmp = root.left; // 记录下左孩子
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);

        return root;


    }


    public static void main(String[] args) {
        int[] data = {4,2,7,1,3,6,9};
        TreeNode root = new TreeNode(data[0]);
        TreeNode cur = root;
        for(int i=1; i<data.length-1; i=i+2){
            cur.left = new TreeNode(data[i]);
            cur.right = new TreeNode(data[i+1]);
        }

        invertTree(root);

    }
}
