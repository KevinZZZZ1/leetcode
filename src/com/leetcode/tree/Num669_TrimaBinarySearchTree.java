package com.leetcode.tree;
// Given a binary search tree and the lowest and highest boundaries as L and R,
// trim the tree so that all its elements lies in [L, R] (R >= L).
// You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.


// 给定一个二叉查找树和左右边界[L,R]，构造一个新的二叉查找树，使得该树中元素值在[L,R]之间
public class Num669_TrimaBinarySearchTree {
    // 思路是：首先二叉查找树是指，左孩子的值小于根节点，右孩子的值大于根节点
    //         所以对于某个节点来说，如果该节点值大于R，则其左孩子可能在结果集中；如果该节点值小于L，则其右孩子可能出现在结果集中；
    //         然后再递归的解决这个问题
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null)
            return null;

        if(root.val>R)
            return trimBST(root.left, L, R);
        if(root.val<L)
            return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }

    public static void main(String[] args) {
        int[] data = {1,0,2};
        TreeNode root = new TreeNode(data[0]);
        TreeNode left = new TreeNode(data[1]);
        TreeNode right = new TreeNode(data[2]);

        root.left = left;
        root.right = right;

        Num669_TrimaBinarySearchTree n = new Num669_TrimaBinarySearchTree();

        n.trimBST(root, 1, 2);


    }

}
