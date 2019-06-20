package com.leetcode.tree;
// Find the sum of all left leaves in a given binary tree.

// 给定一个二叉树，计算出其左叶子中元素值的和
public class Num404_SumofLeftLeaves {
    // 思路是：对于某个节点来说，如果其左孩子是叶子节点，则对值进行加和，否则对其左孩子和右孩子分别递归
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;
        if(isLeaf(root.left))
            return root.left.val+sumOfLeftLeaves(root.right);

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
