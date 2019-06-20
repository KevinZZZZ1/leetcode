package com.leetcode.tree;
// Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
//
//Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

//
public class Num671_SecondMinimumNodeInaBinaryTree {


    public int findSecondMinimumValue(TreeNode root) {
        if(root==null)
            return -1;

        if(root.left==null && root.right==null)
            return -1;

        int rightVal = root.right.val;
        int leftVal = root.left.val;
        if(leftVal == root.val)
            leftVal = findSecondMinimumValue(root.left);
        if(rightVal == root.val)
            rightVal = findSecondMinimumValue(root.right);

        if(leftVal!=-1 && rightVal!=-1)
            return Math.min(leftVal, rightVal);
        if(leftVal!=-1)
            return leftVal;

        return rightVal;
    }

    public static void main(String[] args) {

    }
}
