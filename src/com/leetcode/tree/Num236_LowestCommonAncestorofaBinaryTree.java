package com.leetcode.tree;
// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.


//        _______3______
//      /              \
//  ___5__           ___1__
// /      \         /      \
//6        2       0        8
//        /  \
//       7    4
// For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
// 例如，节点5，1的最近祖先是3，节点5，4的最近祖先是5


// 给定一个二叉树，给定两个节点找出其最近公共祖先
public class Num236_LowestCommonAncestorofaBinaryTree {
    // 思路是：这题和235的不同在于，该题是任意二叉树，而235是BST
    // 所以
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
             if(root == null || root == p || root == q)
                 return root;

             TreeNode left = lowestCommonAncestor(root.left, p, q);
             TreeNode right = lowestCommonAncestor(root.right, p, q);

             if(left != null && right != null)
                 return root;
             return left != null ? left : right;
    }

    public static void main(String[] args) {

    }

}
