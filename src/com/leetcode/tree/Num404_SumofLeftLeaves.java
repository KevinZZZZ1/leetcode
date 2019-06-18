package com.leetcode.tree;
// Find the sum of all left leaves in a given binary tree.

// 给定一个二叉树，计算出其左子树中元素值的和
public class Num404_SumofLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;
        if(isLeaf(root))
            return root.val+sumOfLeftLeaves(root.right);

        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
    }

    private boolean isLeaf(TreeNode t){
        if(t==null)
            return false;
        return t.right!=null || t.left!=null;
    }

    public static void main(String[] args) {

    }

}
